package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.ModifyPostUseCase;
import com.depromeet.coquality.inner.post.vo.ModifyPostCommand;
import com.depromeet.coquality.inner.tag.domain.Tag;
import com.depromeet.coquality.inner.tag.port.driven.TagPort;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ModifyPostService implements ModifyPostUseCase {

    private final PostPort postPort;
    private final TagPort tagPort;

    @Transactional
    @Override
    public void execute(Long userId, final Long postId,
        final ModifyPostCommand modifyPostCommand) {
        final var post = postPort.fetchOne(postId);
        post
            .modifyTitle(userId, modifyPostCommand.title().orElseGet(post::getTitle))
            .modifyContents(userId, modifyPostCommand.contents().orElseGet(post::getContents))
            .modifySummary(userId, modifyPostCommand.summary().orElseGet(post::getSummary))
            .modifyPostStatusCode(userId,
                modifyPostCommand.postStatus().orElseGet(post::getPostStatusCode))
            .modifyThumbnail(userId, modifyPostCommand.thumbnail().orElseGet(post::getThumbnail))
            .modifyPrimaryCategory(
                userId,
                modifyPostCommand.primaryPostCategoryCode().orElseGet(post::getPrimaryCategory)
            )
        ;
        postPort.update(post);

        modifyPostCommand.tags().ifPresent(tagValues -> {
            tagPort.deleteByPostId(postId);
            final var tags = tagValues.stream()
                .map(value -> new Tag(postId, userId, value))
                .collect(Collectors.toSet());

            tagPort.createTags(tags);
        });
    }

}
