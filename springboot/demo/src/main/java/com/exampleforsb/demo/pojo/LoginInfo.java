package com.exampleforsb.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo{
    private Integer id; // ID, 主键
    private String username; // 用户名
    private String password; // 密码
    private String token;
}