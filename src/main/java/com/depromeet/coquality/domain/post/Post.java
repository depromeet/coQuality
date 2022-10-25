package com.depromeet.coquality.domain.post;

import lombok.Getter;

@Getter
public class Post {
    private String title;
    private String description;

    public Post(final String title, final String description) {
        this.title = title;
        this.description = description;
    }

    public static Post of(final String title, final String description) {
        return new Post(title, description);
    }
}
