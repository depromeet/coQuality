package com.depromeet.coquality.inner.post.domain;

import com.depromeet.coquality.inner.post.application.command.CreatePostCommand;
import lombok.Getter;

@Getter
public class Post {

    private String title;

    public Post(String title) {
        this.title = title;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public static Post of(CreatePostCommand createPostCommand) {
        return new Post(createPostCommand.getTitle());
    }
}
