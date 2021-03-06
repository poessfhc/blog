package com.poe.ssfhc.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/1/16 11:13
 * @Version: v1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //分隔符定义
    private static final String splitor = ";";
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //添加新的controller使用分隔符分隔包名，例如"xx.xx.xx.a"+ splitor +"xx.xx.aa.a"
                .apis(RequestHandlerSelectors.basePackage("com.poe.ssfhc.blog.authority.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("poe_blog博客接口文档")
                .description("228专用博客开发")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
