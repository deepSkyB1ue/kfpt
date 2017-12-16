package com.gaeainfo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"com.gaeainfo.module.*.controller", "com.gaeainfo.ybss.*.controller", "com.gaeainfo.framework.ext.*.controller"})

/**
 * Created by Rock on 2016/8/2.
 */
public class SwaggerConfig {
    /**
     * Every Docket bean is picked up by the swagger-mvc framework - allowing for multiple
     * swagger groups i.e. same code base multiple swagger resource listings.
     */

    /*@Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2);

    }*/

    @Bean
    public Docket customDocket() {
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("gaeaToken").description("用户Token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> aParameters = new ArrayList();
        aParameters.add(aParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/rest")
                .select()
                //.paths(PathSelectors.regex("/comm.*"))//过滤的接口
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api说明")
                .build();
    }
}
