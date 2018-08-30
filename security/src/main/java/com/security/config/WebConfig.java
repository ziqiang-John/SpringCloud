package com.security.config;


//import com.security.handler.LoginSuccessHandler;
//import com.security.service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/home").permitAll()//访问：/home 无需登录认证权限
//                .anyRequest().authenticated() //其他所有资源都需要认证，登陆后访问
//                .antMatchers("/hello").hasAuthority("ADMIN") //登陆后之后拥有“ADMIN”权限才可以访问/hello方法，否则系统会出现“403”权限不足的提示
//                .and()
//                .formLogin()
//                .loginPage("/login")//指定登录页是”/login”
//                .permitAll()
//                .successHandler(loginSuccessHandler()) //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
//                .and()
//                .logout()
//                .logoutSuccessUrl("/home") //退出登录后的默认网址是”/home”
//                .permitAll()
//                .invalidateHttpSession(true)
//                .and()
//                .rememberMe()//登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
//                .tokenValiditySeconds(1209600);
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////指定密码加密所使用的加密器为passwordEncoder()
////需要将密码加密后写入数据库
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//        auth.eraseCredentials(false);
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(4);
//    }
//
//    @Bean
//    public LoginSuccessHandler loginSuccessHandler(){
//        return new LoginSuccessHandler();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//        authenticationManagerBuilder.userDetailsService(customUserDetailsService);
//    }
//
//}


/**
 * Created by Administrator on 2017/12/16 0016.
 */
import com.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()//所有的请求需要认证即登陆后才能访问
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //登录页面可任意访问
                .and()
                .logout().permitAll();//注销请求可任意访问
         }
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(customUserService());
    }

}
