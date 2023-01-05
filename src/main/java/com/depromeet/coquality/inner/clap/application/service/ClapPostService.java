package com.depromeet.coquality.inner.clap.application.service;

import com.depromeet.coquality.inner.clap.port.driving.ClapUseCase;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.rank.application.service.RankUseCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClapPostService implements ClapUseCase {

    private final PostPort postPort;
    private final RankUseCaseService rankUseCaseService;

    @Override
    public void execute(Long postId, Long userId) {
        rankUseCaseService.achieveSpecialEditor(userId);
        final var post = postPort
            .fetchOne(postId)
            .increaseClapCount(1L);

        postPort.update(post);
    }
}
