package org.example.bulletinboard.config;

import org.example.bulletinboard.interceptor.SessionInterceptor;
import org.example.bulletinboard.service.AccountSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final AccountSessionService accountSessionService;

    @Autowired
    public WebConfig(AccountSessionService accountSessionService) {
        this.accountSessionService = accountSessionService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor(accountSessionService))
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**");
    }
}
