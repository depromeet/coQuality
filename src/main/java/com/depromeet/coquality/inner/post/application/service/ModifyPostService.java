package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.ModifyPostUseCase;
import com.depromeet.coquality.inner.post.vo.ModifyPostCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyPostService implements ModifyPostUseCase {

    private final PostPort postPort;

    @Transactional
    @Override
    public void execute(final Long id, final ModifyPostCommand modifyPostCommand) {
        final var post = postPort.fetchOne(id);
        post
            .modifyTitle(modifyPostCommand.title().orElseGet(post::getTitle))
            .modifyContents(modifyPostCommand.contents().orElseGet(post::getContents))
            .modifySummary(modifyPostCommand.summary().orElseGet(post::getSummary))
            .modifyPostStatusCode(modifyPostCommand.postStatus().orElseGet(post::getPostStatusCode))
            .modifyThumbnail(modifyPostCommand.thumbnail().orElseGet(post::getThumbnail))
            .modifyPrimaryCategory(
                modifyPostCommand.primaryPostCategoryCode().orElseGet(post::getPrimaryCategory)
            )
        ;
        postPort.update(post);
    }
}
