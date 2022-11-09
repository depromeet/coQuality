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

    public static Post of(
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final String summary,
        final Long views
    ) {
        return new Post(title, contents, primaryPostCategoryCode, summary, views);
    }

    public void modifyPost(final Post post) {
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.primaryPostCategoryCode = post.getPrimaryPostCategoryCode();
        this.summary = post.getSummary();
        this.views = post.getViews();
    }
}