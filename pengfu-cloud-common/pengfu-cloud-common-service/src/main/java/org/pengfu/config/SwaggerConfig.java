package org.pengfu.config;

import io.swagger.annotations.ApiOperation;
import org.pengfu.domain.vo.ResultCode;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PrideZH <332842890@qq.com>
 * @date 2022/7/28 21:44
 */
@Configuration
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false) // 去除默认状态码
                // 添加全局响应状态码
                .globalResponses(HttpMethod.GET, getGlobalResponse())
                .globalResponses(HttpMethod.POST, getGlobalResponse())
                .globalResponses(HttpMethod.PUT, getGlobalResponse())
                .globalResponses(HttpMethod.PATCH, getGlobalResponse())
                .globalResponses(HttpMethod.DELETE, getGlobalResponse());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HongYi Api 文档")
                .description("")
                .contact(new Contact("PrideZH", "", "332842890@qq.com"))
                .version("1.0")
                .build();
    }

    // 全局响应状态码
    private List<Response> getGlobalResponse() {
        List<Response> responseList = new ArrayList<>();
        for (ResultCode resultCode : ResultCode.values()) {
            responseList.add(
                    new ResponseBuilder()
                            .code(String.valueOf(resultCode.code()))
                            .description(resultCode.message())
                            .build());
        }
        return responseList;
    }

}