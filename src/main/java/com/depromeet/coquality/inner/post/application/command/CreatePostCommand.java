package com.depromeet.coquality.inner.post.application.command;

import com.depromeet.coquality.inner.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(builderMethodName = "factory", buildMethodName = "newInstance")
@Getter
public class CreatePostCommand {

    @NonNull
    private final String title;

    public Post toPost() {
        return Post.of(this.title);
    }
}
