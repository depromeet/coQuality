package com.depromeet.coquality.outer.ping.driving.adapter.web;

import com.depromeet.coquality.outer.common.vo.CoQualityResponse;
import com.depromeet.coquality.outer.ping.vo.PingTestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public CoQualityResponse pingTest() {
        return new PingTestResponse();
    }
}
