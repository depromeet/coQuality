package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.NonNull;

public record PostResponse(
    @NonNull Long id,
    @NonNull Long userId,
    @NonNull String title,
    URI thumbnail,
    @NonNull PrimaryPostCategoryCode primaryCategory,
    @NonNull PostStatusCode postStatusCode,
    @NonNull String summary,
    @NonNull Long views,
    @NonNull Long commentCount,
    @NonNull Long clapCount,
    @NonNull LocalDateTime createdAt,
    Set<String> tags
) {

    public static PostResponse of(
        Long id,
        Long userId,
        String title,
        URI thumbnail,
        PrimaryPostCategoryCode primaryCategory,
        PostStatusCode postStatusCode,
        String summary,
        Long views,
        Long commentCount,
        Set<String> tags,
        Long clapCount,
        LocalDateTime createdAt
    ) {
        return new PostResponse(
            id,
            userId,
            title,
            thumbnail,
            primaryCategory,
            postStatusCode,
            summary,
            views,
            commentCount,
            clapCount,
            createdAt,
            tags
        );
    }
}
