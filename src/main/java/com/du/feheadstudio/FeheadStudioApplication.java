package com.du.feheadstudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 86159
 */
@SpringBootApplication
@EnableSwagger2

public class FeheadStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeheadStudioApplication.class, args);
    }

}
