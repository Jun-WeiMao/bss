package com.example.bss.common.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author John Mao
 * @created 1/7/21
 */
@Configuration
public class OpenAPIConfiguration {

    private final BuildProperties buildProperties;

    public OpenAPIConfiguration(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(buildProperties.getName().toUpperCase() + " APIs")
                        .version(buildProperties.getVersion())
                        .description(buildProperties.get("description"))
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
