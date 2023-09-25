package com.myxh.springboot.ssm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@Component
@ConfigurationProperties(prefix = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User
{
    private Long id;
    private String loginName;
    private String nickName;
    private String password;
}
