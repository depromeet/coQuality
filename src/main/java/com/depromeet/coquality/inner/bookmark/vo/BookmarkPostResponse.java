package com.depromeet.coquality.inner.bookmark.vo;

import java.net.URI;
import lombok.Getter;

@Getter
public class BookmarkPostResponse {
    private Long postId;
    private String title;
    private String nickname;
    private String createdAt;
    private String thumbnail;
    private String description;

    private BookmarkPostResponse(final Long postId, final String title, final String nickname, final String createdAt, final String thumbnail, final String description) {
        this.postId = postId;
        this.title = title;
        this.nickname = nickname;
        this.createdAt = createdAt;
        this.thumbnail = thumbnail;
        this.description = description;
    }
    public static BookmarkPostResponse of(final Long postId, final String title, final String nickname, final String createdAt, final String thumbnail, final String description){
        return new BookmarkPostResponse(postId, title, nickname, createdAt, thumbnail, description);
    }
}
