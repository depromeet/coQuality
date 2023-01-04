package com.depromeet.coquality.outer.clap.adapter.driving.web;

import com.depromeet.coquality.inner.clap.port.driving.ClapUseCase;
import com.depromeet.coquality.inner.rank.application.service.RankUseCaseService;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
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
    private final RankUseCaseService rankUseCaseService;

    @PostMapping("/posts/{postId}")
    @Auth
    public void doClap(@PathVariable final Long postId, @UserId Long userId) {
        rankUseCaseService.achieveSpecialEditor(userId);
        clapUseCase.execute(postId, userId);
    }
}
