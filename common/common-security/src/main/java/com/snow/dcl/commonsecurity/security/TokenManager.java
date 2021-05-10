/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package com.snow.dcl.commonsecurity.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName TokenManager
 * (功能描述)
 * token工具类
 * @Author Dcl_Snow
 * @Create 2020/12/22 9:59
 * @Version 1.0.0
 */
@Component
public class TokenManager {
    // token到期时长
    private long tokenExpire = 1000 * 60 * 60;
    // token编码密钥
    private String tokenSecret = "Dcl_Snow";

    // 根据用户名生成token
    public String createToken(String username) {
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpire))
                .signWith(SignatureAlgorithm.HS256, tokenSecret)
                .compact();
        return token;
    }

    // 根据token得到用户信息
    public String getUsernameByToken(String token) {
        String username = Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody().getSubject();
        return username;
    }

}
