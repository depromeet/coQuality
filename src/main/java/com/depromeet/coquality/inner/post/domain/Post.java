package com.depromeet.coquality.inner.post.domain;

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

    public static Post of(String title) {
        return new Post(title);
    }
}
