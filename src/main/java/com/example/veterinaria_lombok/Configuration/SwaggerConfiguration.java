package com.example.veterinaria_lombok.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API VETERINARIA - LOMBOK")
                        .version("1.0")
                        .description("API para Veterinaria")
                        .contact(new Contact()
                                .name("DESARROLLADOR DE API")
                                .email("prueba@prueba.com")));
    }

}