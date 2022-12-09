package com.depromeet.coquality.outer.clap.adapter.driving.web;

import com.depromeet.coquality.inner.clap.port.driving.ClapUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/claps")
public class ClapController {

    private final ClapUseCase clapUseCase;

    @PostMapping("/posts/{postId}")
    public void doClap(@PathVariable final Long postId) {
        clapUseCase.execute(postId);
    }
}
