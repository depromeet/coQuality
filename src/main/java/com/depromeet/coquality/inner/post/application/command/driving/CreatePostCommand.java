package com.depromeet.coquality.inner.post.application.command.driving;

import com.depromeet.coquality.inner.post.domain.Post;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;

public class CreatePostCommand {

    private final String title;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    public CreatePostCommand(@NotEmpty String title) {
        this.title = title;
    }

    public Post toPost() {
        return Post.of(this.title);
    }
}
