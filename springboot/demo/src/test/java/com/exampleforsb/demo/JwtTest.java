package com.exampleforsb.demo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "choupi");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "eW91YXJlY2hvdXBp") //指定加密算法，秘钥
                .addClaims(dataMap) //添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //设置过期时间
                .compact(); //生成令牌

        System.out.println(jwt);
    }
}
