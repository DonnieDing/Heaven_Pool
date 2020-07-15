/**
 * Copyright (C), 2018-2020, Dcl_Snow
 * History:
 * <author>    <create>    <version>   <desc>
 * 作者姓名     修改时间        版本号    功能描述
 */
package org.snow.dcl.heavenpool.config;

import org.snow.dcl.heavenpool.handler.FailureAuthenticationHandler;
import org.snow.dcl.heavenpool.handler.SuccessAuthenticationHandler;
import org.snow.dcl.heavenpool.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * (功能描述)
 * Security配置类
 * @Author Dcl_Snow
 * @Create 2020/7/8 10:48
 * @Version 1.0.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private FailureAuthenticationHandler failureAuthenticationHandler;

    @Autowired
    private SuccessAuthenticationHandler successAuthenticationHandler;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**").anonymous()
                .antMatchers("/*.html","/**/*.html","/**/*.css","/**/*.js").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/dologin")
//                .successForwardUrl("/admin/api/hello")
//                .failureHandler(failureAuthenticationHandler)
//                .successHandler(successAuthenticationHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable()
                .sessionManagement()
                .maximumSessions(1)
                .and();
    }

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/css/**","/img/**");
//    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin").password(bCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER").build());
//        return manager;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
