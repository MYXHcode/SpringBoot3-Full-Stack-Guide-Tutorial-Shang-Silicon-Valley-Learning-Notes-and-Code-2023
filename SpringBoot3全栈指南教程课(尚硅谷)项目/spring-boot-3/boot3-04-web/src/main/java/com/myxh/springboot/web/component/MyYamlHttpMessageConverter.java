package com.myxh.springboot.web.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author MYXH
 * @date 2023/9/18
 * @description
 * 自定义的 YAML HTTP 消息转换器
 * 用于将对象转换为 YAML 格式的内容
 */
public class MyYamlHttpMessageConverter extends AbstractHttpMessageConverter<Object>
{
    // 将对象转换为 YAML 的 ObjectMapper
    private final ObjectMapper objectMapper;

    public MyYamlHttpMessageConverter()
    {
        // 告诉 SpringBoot 这个 MessageConverter 支持哪种媒体类型
        super(new MediaType("text", "yaml", StandardCharsets.UTF_8),
                new MediaType("text", "yml", StandardCharsets.UTF_8));

        // 创建 YAMLFactory 并禁用写入文档起始标记
        YAMLFactory factory = new YAMLFactory().
                disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        this.objectMapper = new ObjectMapper(factory);
    }

    /**
     * 判断该转换器是否支持将指定类型的对象转换为 YAML
     *
     * @param clazz 要测试支持的类
     * @return 如果支持转换，则返回 true；否则返回 false
     */
    @Override
    protected boolean supports(Class<?> clazz)
    {
        // 只要是对象类型，不是基本类型和数组类型，都支持
        return !clazz.isPrimitive() && !clazz.isArray();
    }

    /**
     * 从 HTTP 输入消息中读取数据并将其转换为指定类型的对象
     * {@code @RequestBody} 把对象怎么读进来
     *
     * @param clazz        要返回的对象类型
     * @param inputMessage 要从中读取的 HTTP 输入消息
     * @return 转换后的对象
     * @throws IOException                     IO 异常
     * @throws HttpMessageNotReadableException Http 消息不可读异常
     */
    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException
    {
        return objectMapper.readValue(inputMessage.getBody(), clazz);
    }

    /**
     * 将指定对象写入 HTTP 输出消息
     * {@code @ResponseBody} 把对象怎么写出去
     *
     * @param methodReturnValue 要写入输出消息的对象
     * @param outputMessage     要写入的 HTTP 输出消息
     * @throws IOException                     IO 异常
     * @throws HttpMessageNotWritableException Http 消息不可写入异常
     */
    @Override
    protected void writeInternal(Object methodReturnValue, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException
    {
        // 使用 try-with-resources 语句以自动关闭流
        try (OutputStream os = outputMessage.getBody())
        {
            this.objectMapper.writeValue(os, methodReturnValue);
        }
    }
}
