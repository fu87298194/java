//package com.huhu.springbootdemo.configuration;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.RegexRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.regex.Pattern;
//
//@EnableWebSecurity
//public class SecurityConfigBak extends WebSecurityConfigurerAdapter {
//    //授权
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //链式编程
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/system/**").hasRole("role1");
//
//        //跨站请求伪造放行处理
//        http.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
//            //放行这几种请求
//            //private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
//            private Pattern allowedMethods = Pattern.compile("^(HEAD|TRACE|OPTIONS)$");
//            //放行rest请求
//            private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("^/rest/.*", null);
//            //放行druid
//            @Override
//            public boolean matches(HttpServletRequest request) {
//                if (allowedMethods.matcher(request.getMethod()).matches()) {
//                    return false;
//                }
//                String servletPath = request.getServletPath();
//                if (servletPath.contains("/druid")) {
//                    return false;
//                }
//                return !unprotectedMatcher.matches(request);
//            }
//        });
//
//        //登录(用户名默认username，密码默认password，记住我默认remember-me)
//        http.formLogin()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginPage("/systemlogin");
//        //.loginProcessingUrl("/login");配置提交到自带的login，html页面的form action要相应改
//
//        //退出
//        http.logout().logoutSuccessUrl("/systemlogin");
//
//        //记住我(cookie默认两周)
//        http.rememberMe().rememberMeParameter("remember-me");
//    }
//
//    //认证
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("role1")
//                .and()
//                .withUser("chen").password(new BCryptPasswordEncoder().encode("123456")).roles("role2");
//    }
//}