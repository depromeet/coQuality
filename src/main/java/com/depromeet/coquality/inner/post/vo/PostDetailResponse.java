package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.net.URI;
import java.time.LocalDateTime;
import lombok.NonNull;

public record PostDetailResponse(
    @NonNull Long id,
    @NonNull Long userId,
    @NonNull String title,
    @NonNull String contents,
    URI thumbnail,
    @NonNull PrimaryPostCategoryCode primaryCategory,
    @NonNull PostStatusCode postStatusCode,
    @NonNull String summary,
    @NonNull Long views,
    @NonNull LocalDateTime createdAt
) {

    public static PostDetailResponse of(
        Long id,
        Long userId,
        String title,
        String contents,
        URI thumbnail,
        PrimaryPostCategoryCode primaryCategory,
        PostStatusCode postStatusCode,
        String summary,
        Long views,
        LocalDateTime createdAt
    ) {
        return new PostDetailResponse(
            id,
            userId,
            title,
            contents,
            thumbnail,
            primaryCategory,
            postStatusCode,
            summary,
            views,
            createdAt
        );
    }
}
