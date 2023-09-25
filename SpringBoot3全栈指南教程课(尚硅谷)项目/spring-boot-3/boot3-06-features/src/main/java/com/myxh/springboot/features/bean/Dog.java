package com.myxh.springboot.features.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@Profile("test")
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dog
{
    private Long id;
    private String name;
}
