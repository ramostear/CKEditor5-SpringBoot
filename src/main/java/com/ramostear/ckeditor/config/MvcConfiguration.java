package com.ramostear.ckeditor.config;

import com.ramostear.ckeditor.common.Consts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author :       ramostear/树下魅狐
 * <p>This java file was created by ramostear in 2020/7/7 0007 17:56.
 * The following is the description information about this file:</p>
 * <p>description:</p>
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(600000000);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("file:"+ Consts.FILE_STORAGE_ROOT+"/images/");
        super.addResourceHandlers(registry);
    }
}
