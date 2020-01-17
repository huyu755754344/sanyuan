package com.sanyuan.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

@Configuration
public class FileConfig {
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory config = new MultipartConfigFactory();
        config.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        config.setMaxRequestSize(DataSize.of(50, DataUnit.MEGABYTES));
        return config.createMultipartConfig();
    }
}
