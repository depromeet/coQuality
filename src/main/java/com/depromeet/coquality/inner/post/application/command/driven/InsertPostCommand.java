package com.depromeet.coquality.inner.post.application.command.driven;

import com.depromeet.coquality.inner.post.domain.Post;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class InsertPostCommand {

    private final String title;

    public InsertPostCommand(@NonNull Post post) {
        this.title = post.getTitle();
    }
}
