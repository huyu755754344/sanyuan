package com.sanyuan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sanyuan.filter.UserInfoFilter;

@Configuration
public class FilterConfig {
@Autowired
private UserInfoFilter infoFilter;
	  
	    
	    @Bean
	    public FilterRegistrationBean status() {
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(infoFilter);
	        registration.addUrlPatterns("/sellCar");
	         registration.setName("statusFilter");
	        registration.setOrder(1);  //值越小，Filter越靠前。
	        return registration;
	    }
}
