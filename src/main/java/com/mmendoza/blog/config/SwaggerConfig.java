package com.mmendoza.blog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API BLOG",
                description = "A blog about refrigeration, air conditioning, and washing machine repair",
                termsOfService = "MZ.devs",
                version = "1.0.0"
        )
)
public class SwaggerConfig {
}
