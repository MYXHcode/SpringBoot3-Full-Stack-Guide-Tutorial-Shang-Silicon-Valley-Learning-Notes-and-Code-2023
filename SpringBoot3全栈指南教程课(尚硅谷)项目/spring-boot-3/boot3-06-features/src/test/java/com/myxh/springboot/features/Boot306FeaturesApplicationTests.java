package com.myxh.springboot.features;

import com.myxh.springboot.features.service.HelloService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

// 具备测试 SpringBoot 应用容器中所有组件的功能，测试类必须在主程序所在的包及其子包
@SpringBootTest
class Boot306FeaturesApplicationTests
{
    // 自动注入任意组件即可测试
    @Autowired
    HelloService helloService;

    @DisplayName("测试 sum() 方法 ")
    @Test
    void contextLoads()
    {
        Integer sum = helloService.sum(1, 2);
        Assertions.assertEquals(3, sum);
    }

    @DisplayName("测试1")
    @Test
    public void test1()
    {
        System.out.println("test1");
    }

    // 参数化测试
    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three"})
    @DisplayName("参数化测试1")
    public void parameterizedTest1(String string)
    {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }

    @ParameterizedTest
    // 指定方法名，返回值就是测试用的参数
    @MethodSource("method")
    @DisplayName("方法来源参数")
    public void testWithExplicitLocalMethodSource(String name)
    {
        System.out.println(name);
        Assertions.assertNotNull(name);
    }

    static Stream<String> method()
    {
        // 返回 Stream 则可
        return Stream.of("apple", "banana");
    }

    // 所有测试方法运行之前先运行这个，只打印一次
    @BeforeAll
    static void initAll()
    {
        System.out.println("hello");
    }

    // 每个测试方法运行之前先运行这个，每个方法运行打印一次
    @BeforeEach
    void init()
    {
        System.out.println("world");
    }
}
