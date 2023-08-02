package com.easy.panda.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/4/25 11:31
 * @description
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI springDocOpenAPI() {
        return new OpenAPI().info(new Info()
                        .title("MAGS API")
                        .description("MAGS接口文档说明")
                        .version("v0.0.1")
                        .license(new License().name("项目接口地址")
                                .url("https://blog.csdn.net/weihao0240/category_12166012.html")))
                // 配置Authorizations
                .components(new Components().addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")));
    }
    /**
     * demo 分组
     *
     * @return demo分组接口
     */
//    @Bean
//    public GroupedOpenApi siteApi() {
//        return GroupedOpenApi.builder()
//                .group("user接口")
//                .pathsToMatch("/user/**")
//                .build();
//    }
//
//    /**
//     * sys 分组
//     *
//     * @return sys分组接口
//     */
//    @Bean
//    public GroupedOpenApi adminApi() {
//        return GroupedOpenApi.builder()
//                .group("sys接口")
//                .pathsToMatch("/sys/**")
//                .build();
//    }
}
