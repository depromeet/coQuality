package com.depromeet.coquality.inner.post.domain;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.inner.post.domain.policy.validation.PostValidationPolicy;
import lombok.Getter;

@Getter
public class Post {

    private String title;
    private String contents;
    private PrimaryPostCategoryCode primaryPostCategoryCode;
    private PostStatusCode postStatusCode;
    private String summary;
    private Long views;

    private Post(
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final PostStatusCode postStatusCode,
        final String summary,
        final Long views
    ) {
        this.title = title;
        this.contents = contents;
        this.primaryPostCategoryCode = primaryPostCategoryCode;
        this.postStatusCode = postStatusCode;
        this.summary = summary;
        this.views = views;
        PostValidationPolicy.validatePost(this);
    }

    public static Post of(
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final PostStatusCode postStatusCode,
        final String summary
    ) {
        return new Post(title, contents, primaryPostCategoryCode, postStatusCode, summary, 0L);
    }

    public static Post of(
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final PostStatusCode postStatusCode,
        final String summary,
        final Long views
    ) {
        return new Post(title, contents, primaryPostCategoryCode, postStatusCode, summary, views);
    }

}