package com.depromeet.coquality.inner.post.domain;

public record Post(String title) {

    public static Post of(final String title) {
        return new Post(title);
    }

}