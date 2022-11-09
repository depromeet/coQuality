package com.depromeet.coquality.outer.user.external.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.depromeet.coquality")
@Configuration
public class FeignClientConfig {
}
