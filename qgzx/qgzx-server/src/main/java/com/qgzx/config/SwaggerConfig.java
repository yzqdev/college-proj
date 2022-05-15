package com.qgzx.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 的配置
 *
 * @author yanni
 * @date 2021/11/21
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "我的博客",
                version = "1.0",
                description = "我的博客",
                contact = @Contact(name = "TOM")
        )
)

public class SwaggerConfig {
    @Bean
    public GroupedOpenApi docker() {
        return GroupedOpenApi.builder()
                .packagesToScan("com.qgzx.controller")
                .group("api")
                .pathsToMatch("/**").build();


    }


}