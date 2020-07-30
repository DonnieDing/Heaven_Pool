/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package org.snow.dcl.heavenpool.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName MyAccessDecisionManager
 * (功能描述)
 * 自定义权限决策管理类
 * @Author Dcl_Snow
 * @Create 2020/7/27 23:37
 * @Version 1.0.0
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     * 功能描述:
     * 〈判断是否拥有权限的决策方法〉
     *
     * @param authentication 是自定义的MyUserDetailsService中获取的该用户的权限集合
     * @param o              包含客户端发起请求的request信息，即请求的uri
     * @param collection     是MyInvocationSecurityMetadataSource的getAttributes()方法的返回结果
     * @Author:Dcl_Snow
     * @Date: 2020/7/27 23:39
     * @version: 1.0.0
     * @return:
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (collection == null || collection.size() <= 0){
            return;
        }
        ConfigAttribute configAttribute;
        String needRole;
        for(Iterator<ConfigAttribute> iterator = collection.iterator();iterator.hasNext();){
            configAttribute=iterator.next();
            needRole = configAttribute.getAttribute();
            System.out.println(needRole);
            for (GrantedAuthority grantedAuthority:authentication.getAuthorities()){
                if(needRole.trim().equals(grantedAuthority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("无权限访问！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
