/* SPDX-License-Identifier: BSD-3-Clause */
 
package it.mds.sdk.flusso.dir;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@ComponentScan({"it.mds.sdk.flusso.dir.controller","it.mds.sdk.flusso.dir",
        "it.mds.sdk.rest.persistence.entity","it.mds.sdk.libreriaregole.validator",
        "it.mds.sdk.flusso.dir.service","it.mds.sdk.flusso.dir.tracciato",
        "it.mds.sdk.gestoreesiti", "it.mds.sdk.flusso.dir.parser.regole",
        "it.mds.sdk.flusso.dir.parser.regole.conf",
        "it.mds.sdk.connettoremds"})
@Slf4j
@OpenAPIDefinition(info=@Info(title = "SDK Ministero Della Salute - Flusso DIR", version = "0.0.5-SNAPSHOT", description = "Flusso Diretta"))
public class FlussoDir {
    public static void main(String[] args) {
        SpringApplication.run(FlussoDir.class, args);
        log.debug("* LINK SWAGGER: http://localhost:port/swagger-ui/");
        log.debug("* LINK JSON OPENAPI: http://localhost:8080/v3/api-docs.yaml");
    }
}
