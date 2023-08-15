package com.alsaba.backend.configs;

import com.alsaba.backend.interceptors.CorsOriginInterceptor;
import com.alsaba.backend.interceptors.PostPaysInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class InterceptorsConfig extends WebMvcConfigurationSupport {

    private final PostPaysInterceptor postPays ;
    private final CorsOriginInterceptor corsOriginInterceptor ;

    public InterceptorsConfig(PostPaysInterceptor postPays , CorsOriginInterceptor corsOriginInterceptor) {
        this.postPays = postPays;
        this.corsOriginInterceptor = corsOriginInterceptor ;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(postPays).addPathPatterns("/pays/**");
        //registry.addInterceptor(corsOriginInterceptor);

    }
}
