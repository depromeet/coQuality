package com.depromeet.coquality.outer.ping.driving.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingTestController {

    @GetMapping
    public void pingTest() {
    }
}
