package com.myxh.springboot.features.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MYXH
 * @date 2023/9/23
 */
// @Profile("dev")
// @Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cat
{
    private Long id;
    private String name;
}
