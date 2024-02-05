package com.groupeisi.etudiantspringboot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info =
    @Info(
            title = "Etudiant CRUD", version = "1.0", description = "Documentation de CRUD etudiant API v1.0"
    )
        , servers = @Server(url = "http://localhost:8080", description = "Local ENV")
)
@Configuration
public class OpenApiConfig {
}
