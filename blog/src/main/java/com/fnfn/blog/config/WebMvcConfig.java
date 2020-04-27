package com.fnfn.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fnfn.blog.interceptor.LoggerInterceptor;

/**
 * 클래스명: <code>WebMvcConfig</code><br>
 *
 * 빈 등록
 *
 * @author fnfnk
 * @since 2020. 4. 24.
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * interceptor 등록
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor()  );
    }

}
