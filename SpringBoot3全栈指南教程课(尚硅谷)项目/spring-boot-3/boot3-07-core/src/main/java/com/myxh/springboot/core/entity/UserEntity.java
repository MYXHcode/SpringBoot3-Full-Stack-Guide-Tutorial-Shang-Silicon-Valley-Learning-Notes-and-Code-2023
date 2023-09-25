package com.myxh.springboot.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity
{
    private String username;
    private String password;
}
