package com.depromeet.coquality.outer.rank.adapter.driving.web;


import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ranks")
public class RankController {
    private final RankUseCase rankUseCase;

    @PutMapping("/up")
    @Auth
    public void advancementUserRank(@UserId final Long userId){
        return rankUseCase.execute(userId);
    }
}
