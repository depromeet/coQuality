package com.depromeet.coquality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CoQualityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoQualityApplication.class, args);
    }

}
