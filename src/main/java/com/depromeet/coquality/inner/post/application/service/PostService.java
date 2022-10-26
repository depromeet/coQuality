package com.depromeet.coquality.inner.post.application.service;

import com.depromeet.coquality.inner.post.application.command.driven.FetchPostCommand;
import com.depromeet.coquality.inner.post.application.command.driven.InsertPostCommand;
import com.depromeet.coquality.inner.post.application.command.driven.UpdatePostCommand;
import com.depromeet.coquality.inner.post.application.command.driving.CreatePostCommand;
import com.depromeet.coquality.inner.post.application.command.driving.ModifyPostCommand;
import com.depromeet.coquality.inner.post.port.driven.PostPort;
import com.depromeet.coquality.inner.post.port.driving.PostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements PostUseCase {

    private final PostPort postPort;

    @Override
    public void create(final CreatePostCommand createPostCommand) {
        final var post = createPostCommand.toPost();

        postPort.insert(new InsertPostCommand(post));
    }

    @Override
    public void modify(ModifyPostCommand modifyPostCommand) {
        final var post = postPort.fetch(new FetchPostCommand(modifyPostCommand.getId()));

        post.modifyTitle(modifyPostCommand.getTitleOpt().orElseGet(post::getTitle));
        postPort.update(new UpdatePostCommand(modifyPostCommand.getId(), post));
    }
}
