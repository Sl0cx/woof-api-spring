package com.m2i.woof.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "M2i formation",
                        email = "m2i-lille@gmail.com",
                        url = "www.google.com"
                ),
                description = "Api pour l'application Woof",
                title = "Formation spring boot",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "SERVER DEV",
                        url = "http://localhost:8083/m2i/woof/api/"
                ),
                @Server(
                        description = "SERVER PROD",
                        url = "http://nonServeur.m2i"
                )
        }, security = {
                @SecurityRequirement(
                        name = "BearerAuth"
                )

}
)
@SecurityScheme(
        name = "BearerAuth",
        description = "Connexion via JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

}
