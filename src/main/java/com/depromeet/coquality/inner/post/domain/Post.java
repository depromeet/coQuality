package com.depromeet.coquality.inner.post.domain;

import lombok.Getter;

@Getter
public class Post {

    private String title;

    public Post(String title) {
        this.title = title;
    }

    public static Post of(final String title) {
        return new Post(title);
    }

    public void modifyTitle(final String title) {
        // 비즈니스 정책 검증 생략
        this.title = title;
    }

}