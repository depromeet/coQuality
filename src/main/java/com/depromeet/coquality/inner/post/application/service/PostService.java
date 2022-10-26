package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.application.command.driven.UpdatePostCommand;
import com.depromeet.coquality.inner.post.application.command.driving.ModifyPostCommand;
import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.PostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements PostUseCase {

    private final PostPort postPort;

    @Override
    public void create(final Post post) {
        postPort.insert(post);
    }

    @Override
    public void modify(final Long id, final ModifyPostCommand modifyPostCommand) {
        final var post = postPort.fetch(id);

        post.modifyTitle(modifyPostCommand.getTitleOpt().orElseGet(post::getTitle));
        postPort.update(new UpdatePostCommand(id, post));
    }
}
