package com.gabrielveras.rickandmorty_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rick and Morty API")
                        .version("1.0.0")
                        .description("API que consome a Rick and Morty API e expõe endpoints próprios com cache"));
    }
}