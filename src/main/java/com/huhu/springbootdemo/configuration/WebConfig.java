//package com.huhu.springbootdemo.configuration;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
//@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    /**
//     * 添加处理程序以提供来自 Web 应用程序根目录、类路径等特定位置的静态资源，例如图像、js 和 css 文件。
//     *
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
//    }
//}