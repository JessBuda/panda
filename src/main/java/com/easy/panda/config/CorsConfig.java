package com.easy.panda.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/4/25 13:51
 * @description 跨域配置
 */
@Configuration
@ConditionalOnProperty(name = "ehl.config.cross-origin.enabled", matchIfMissing = true)
public class CorsConfig {
    @Value("${ehl.config.cross-origin.allow-credentials:true}")
    private boolean allowCredentials;
    @Value("${ehl.config.cross-origin.allow-origins:*}")
    private String allowedOrigins;
    @Value("${ehl.config.cross-origin.allow-headers:*}")
    private String allowedHeaders;
    @Value("${ehl.config.cross-origin.allow-methods:*}")
    private String allowedMethods;
    @Value("${ehl.config.cross-origin.max-age:3600}")
    private Long maxAge;

    /**
     * 跨域过滤器
     * @return
     */
    @Bean
    CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(allowedOrigins));
        configuration.setAllowedMethods(Arrays.asList(allowedMethods));
        configuration.setAllowedHeaders(Arrays.asList(allowedHeaders));
        configuration.setAllowCredentials(allowCredentials);
        configuration.setMaxAge(maxAge);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
