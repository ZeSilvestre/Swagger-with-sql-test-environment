package br.com.estudos.ambienteteste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

  @Bean
  OpenAPI openAPI() {
    Contact contact =
        new Contact()
            .name("Projeto de Estudos")
            .url("https://github.com/")
            .email("contato@example.com");

    Info info =
        new Info()
            .title("Ambiente Teste API")
            .version("1.0.0")
            .description("API de estudos com Spring Boot, Swagger/OpenAPI e PostgreSQL.")
            .contact(contact);

    return new OpenAPI().openapi("3.0.3").info(info);
  }
}
