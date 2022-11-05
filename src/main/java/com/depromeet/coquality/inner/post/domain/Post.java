package com.depromeet.coquality.inner.post.domain;

import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.inner.post.domain.policy.validation.PostValidationPolicy;
import lombok.Getter;

@Getter
public class Post {

    private String title;
    private String contents;
    private PrimaryPostCategoryCode primaryPostCategoryCode;
    private String summary;
    private Long views;

    private Post(
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final String summary,
        final Long views
    ) {
        this.title = title;
        this.contents = contents;
        this.primaryPostCategoryCode = primaryPostCategoryCode;
        this.summary = summary;
        this.views = views;
        PostValidationPolicy.validatePost(this);
    }

    public static Post of(
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final String summary
    ) {
        return new Post(title, contents, primaryPostCategoryCode, summary, 0L);
    }

    public void modifyTitle(final String title) {
        // 비즈니스 정책 검증 생략
        this.title = title;
    }
}