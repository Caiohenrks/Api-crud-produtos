/*
 * LinkedIn: https://www.linkedin.com/in/caiohenrks/
 * Github: https://github.com/Caiohenrks
 */
package com.mercadinho.vendas.doc;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Caiohenrks
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contat() {
        return new Contact("Caiohenrks", "htts://caiohenrks.com.br", "contato@caiohenrks.com.br");
    }

    private ApiInfoBuilder informacoesApi() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Mercadinho - REST API");
        apiInfoBuilder.description("CRUD para produtos");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Empresa");
        apiInfoBuilder.licenseUrl("htts://caiohenrks.com.br");
        apiInfoBuilder.contact(this.contat());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
                .apis(RequestHandlerSelectors.basePackage("com.mercadinho.vendas.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<>(Arrays.asList("application/json")))
                .produces(new HashSet<>(Arrays.asList("application/json")));
        return docket;
    }

}
