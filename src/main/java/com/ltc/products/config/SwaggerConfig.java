package com.ltc.products.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Product Management"
                ),
                description = "OpenApi documentation for Frontend",
                title = "Product Project Api",
                version = "1.0",
                termsOfService = "Terms of service"
        )

)
public class SwaggerConfig {


}
