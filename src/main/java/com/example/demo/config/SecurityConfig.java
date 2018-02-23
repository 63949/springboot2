package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal,password as crendentails,true from user where email=?")
                .authoritiesByUsernameQuery("select user_email as principal,role_name as role from user_roles where user_email=?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http); 这里必须把默认的实现干掉
        http.authorizeRequests()
                .antMatchers("/register","/","/about","/login","/css/**","/webjars/**").permitAll()// 允许访问的网址
                .antMatchers("/profile").hasAnyRole("USER,ADMIN")
                .antMatchers("/users","/addTask").hasRole("ADMIN")
//                .anyRequest().authenticated() // 其它的都要登录验证
                .and().formLogin().loginPage("/login").permitAll() // 指定登录页面
                .defaultSuccessUrl("/profile") // 默认登录成功后转入页面
                .and().logout().logoutSuccessUrl("/login"); // 默认登出成功页面
    }
}
