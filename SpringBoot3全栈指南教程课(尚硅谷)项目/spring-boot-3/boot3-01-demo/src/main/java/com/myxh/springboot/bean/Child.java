package com.myxh.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/11
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Child
{
    private String name;
    private Integer age;
    private Date birthDay;
    // 数组
    private List<String> text;
}