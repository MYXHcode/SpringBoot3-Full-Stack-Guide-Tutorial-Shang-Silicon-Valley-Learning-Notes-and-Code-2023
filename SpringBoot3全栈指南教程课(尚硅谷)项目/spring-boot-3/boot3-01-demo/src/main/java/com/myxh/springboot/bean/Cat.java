package com.myxh.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/11
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cat
{
    private String name;
    private Integer age;
}
