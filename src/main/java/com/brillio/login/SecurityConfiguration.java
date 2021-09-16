package com.brillio.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 @Autowired
 MongoUserDetailsService userDetailsService;

 @Override
 protected void configure(HttpSecurity http) throws Exception {
   http
     .csrf().disable()
     .authorizeRequests().anyRequest().authenticated()
     .and()
     .formLogin()
     .permitAll()
     .defaultSuccessUrl("/success")
     .failureUrl("/fail")
     .and().logout()
     .and().httpBasic()
     .and().sessionManagement().disable();
//	 http.authorizeRequests()
//     .antMatchers("/", "/home").permitAll()
//     .anyRequest().authenticated()
//     .and()
//     .formLogin()
//     .loginPage("")
//     .permitAll()
//     .defaultSuccessUrl("/success")
//     .failureUrl("/fail")
//     .and()
//     .logout()
//     .permitAll()
//     .and()
//     .httpBasic();
 }

 @Bean
 public PasswordEncoder passwordEncoder() {
   return new BCryptPasswordEncoder();
 }

 @Override
 public void configure(AuthenticationManagerBuilder builder) 
throws Exception {
   builder.userDetailsService(userDetailsService);
//   builder.jdbcAuthentication()
//   .userDetailsService(userDetailsService)
//   .passwordEncoder(new BCryptPasswordEncoder());
 }
}