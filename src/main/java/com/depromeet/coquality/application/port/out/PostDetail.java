package com.depromeet.coquality.application.port.out;

import lombok.Getter;

@Getter
public class PostDetail {
    private String title;
    private String description;

    private PostDetail(final String title, final String description) {
        this.title = title;
        this.description = description;
    }

    public static PostDetail of (final String title, final String description){
        return new PostDetail(title, description);
    }
}
