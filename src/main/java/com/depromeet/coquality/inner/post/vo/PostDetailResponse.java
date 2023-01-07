package com.depromeet.coquality.inner.post.vo;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.NonNull;

public record PostDetailResponse(
    @NonNull Long id,
    @NonNull Long userId,
    @NonNull String title,
    @NonNull String contents,
    String userName,
    URI thumbnail,
    @NonNull PrimaryPostCategoryCode primaryCategory,
    @NonNull PostStatusCode postStatusCode,
    @NonNull String summary,
    @NonNull Long views,
    Long commentCount,
    Set<String> tags,
    @NonNull Long clapCount,
    boolean bookmarkYn,
    @NonNull LocalDateTime createdAt
) {

    public static PostDetailResponse of(
        Long id,
        Long userId,
        String title,
        String contents,
        String userName,
        URI thumbnail,
        PrimaryPostCategoryCode primaryCategory,
        PostStatusCode postStatusCode,
        String summary,
        Long views,
        Long commentCount,
        Set<String> tags,
        Long clapCount,
        boolean bookmarkYn,
        LocalDateTime createdAt
    ) {
        return new PostDetailResponse(
            id,
            userId,
            title,
            contents,
            userName,
            thumbnail,
            primaryCategory,
            postStatusCode,
            summary,
            views,
            commentCount,
            tags,
            clapCount,
            bookmarkYn,
            createdAt
        );
    }
}
