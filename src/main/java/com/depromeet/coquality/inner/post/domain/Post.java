package com.depromeet.coquality.inner.post.domain;

import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.inner.post.domain.policy.validation.PostValidationPolicy;
import java.net.URI;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private final Long id;
    private final Long userId;
    private String title;
    private String contents;
    private URI thumbnail;
    private PrimaryPostCategoryCode primaryCategory;
    private PostStatusCode postStatusCode;
    private String summary;
    private Long views;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private Post(
        final Long id,
        final Long userId,
        final String title,
        final String contents,
        final URI thumbnail,
        final PrimaryPostCategoryCode primaryCategory,
        final PostStatusCode postStatusCode,
        final String summary,
        final Long views
    ) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.thumbnail = thumbnail;
        this.primaryCategory = primaryCategory;
        this.postStatusCode = postStatusCode;
        this.summary = summary;
        this.views = views;
        PostValidationPolicy.validatePost(this);
    }

    public static Post of(
        final Long id,
        final Long userId,
        final String title,
        final String contents,
        final URI thumbnail,
        final PrimaryPostCategoryCode primaryCategory,
        final PostStatusCode postStatusCode,
        final String summary
    ) {
        return of(
            id,
            userId,
            title,
            contents,
            thumbnail,
            primaryCategory,
            postStatusCode,
            summary,
            0L
        );
    }

    public static Post of(
        final Long id,
        final Long userId,
        final String title,
        final String contents,
        final URI thumbnail,
        final PrimaryPostCategoryCode primaryCategory,
        final PostStatusCode postStatusCode,
        final String summary,
        final Long views
    ) {
        return Post.factory()
            .id(id)
            .userId(userId)
            .title(title)
            .contents(contents)
            .thumbnail(thumbnail)
            .primaryCategory(primaryCategory)
            .postStatusCode(postStatusCode)
            .summary(summary)
            .views(views)
            .newInstance();
    }

    public Post modifyTitle(String title) {
        PostValidationPolicy.validateTitle(title);
        this.title = title;
        return this;
    }

    public Post modifyContents(String contents) {
        PostValidationPolicy.validateContents(contents);
        this.contents = contents;
        return this;
    }

    public Post modifyThumbnail(URI thumbnail) {
        PostValidationPolicy.validateThumbnail(thumbnail);
        this.thumbnail = thumbnail;
        return this;
    }

    public Post modifyPrimaryCategory(
        PrimaryPostCategoryCode primaryCategory) {
        PostValidationPolicy.validatePrimaryCategory(primaryCategory);
        this.primaryCategory = primaryCategory;
        return this;
    }

    public Post modifyPostStatusCode(
        PostStatusCode postStatusCode) {
        PostValidationPolicy.validatePostStatusCodeModification(
            this.postStatusCode,
            postStatusCode
        );
        this.postStatusCode = postStatusCode;
        return this;
    }

    public Post modifySummary(String summary) {
        PostValidationPolicy.validateSummary(summary);
        this.summary = summary;
        return this;
    }
}