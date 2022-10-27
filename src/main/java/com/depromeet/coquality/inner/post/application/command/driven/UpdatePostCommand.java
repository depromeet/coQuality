package com.depromeet.coquality.inner.post.application.command.driven;

import com.depromeet.coquality.inner.post.domain.Post;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class UpdatePostCommand {

    private final Long id;

    private final String title;

    public UpdatePostCommand(@NonNull Long id, @NonNull Post post) {
        this.id = id;
        this.title = post.getTitle();
    }
}
