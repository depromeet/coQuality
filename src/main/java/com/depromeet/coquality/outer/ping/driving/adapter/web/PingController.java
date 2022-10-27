package com.depromeet.coquality.outer.ping.driving.adapter.web;

import com.depromeet.coquality.outer.common.vo.CoqualityResponse;
import com.depromeet.coquality.outer.ping.vo.PingTestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public CoqualityResponse pingTest() {
        return new PingTestResponse();
    }
}
