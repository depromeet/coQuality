package com.depromeet.coquality.inner.post.application.command.driven;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class FetchPostCommand {

    private final Long id;

    public FetchPostCommand(@NonNull Long id) {
        this.id = id;
    }
}
