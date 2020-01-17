package com.sanyuan.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public HandlerInterceptor getMyInterceptor(){
        return new LoginInterceptor();
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration registration = registry.addInterceptor(getMyInterceptor());
		registration.addPathPatterns("/**");
		registration.excludePathPatterns("/");
		registration.excludePathPatterns("/login");
		registration.excludePathPatterns("/forget");
		registration.excludePathPatterns("/register");
		registration.excludePathPatterns("/toLogin");
		registration.excludePathPatterns("/css/**");
		registration.excludePathPatterns("/img/**");
		registration.excludePathPatterns("/js/**");
		registration.excludePathPatterns("/getSeries");
		
	}
}