package com.depromeet.coquality.outer.post.entity;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.outer.common.entity.BaseEntity;
import java.net.URI;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "Post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostEntity extends BaseEntity {

    private String title;
    private String contents;
    private String thumbnail;
    @Enumerated(value = EnumType.STRING)
    private PrimaryPostCategoryCode primaryCategory;
    @Enumerated(value = EnumType.STRING)
    private PostStatusCode postStatusCode;
    private String summary;
    private Long views;

    private Long userId;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private PostEntity(
        @NonNull String title,
        @NonNull String contents,
        String thumbnail,
        @NonNull PrimaryPostCategoryCode primaryCategory,
        @NonNull PostStatusCode postStatusCode,
        @NonNull String summary,
        @NonNull Long views,
        @NonNull Long userId
    ) {
        this.title = title;
        this.contents = contents;
        this.thumbnail = thumbnail;
        this.primaryCategory = primaryCategory;
        this.postStatusCode = postStatusCode;
        this.summary = summary;
        this.views = views;
        this.userId = userId;
    }

    public static PostEntity from(Post post) {
        final var thumbnail = post.getThumbnail() == null ?
            null :
            String.valueOf(post.getThumbnail());

        return PostEntity.factory()
            .title(post.getTitle())
            .userId(post.getUserId())
            .contents(post.getContents())
            .thumbnail(thumbnail)
            .primaryCategory(post.getPrimaryCategory())
            .postStatusCode(post.getPostStatusCode())
            .summary(post.getSummary())
            .views(post.getViews())
            .newInstance();
    }

    public Post toPost() {
        return Post.of(
            getId(),
            userId,
            title,
            contents,
            URI.create(thumbnail),
            primaryCategory,
            postStatusCode,
            summary,
            views
        );
    }

    public void modifyTitle(@NonNull String title) {
        this.title = title;
    }

    public void modifyContents(@NonNull String contents) {
        this.contents = contents;
    }

    public void changePrimaryPostCategoryCode(
        @NonNull PrimaryPostCategoryCode primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public void changePostStatusCode(@NonNull PostStatusCode postStatusCode) {
        this.postStatusCode = postStatusCode;
    }

    public void modifySummary(@NonNull String summary) {
        this.summary = summary;
    }

    public void increaseViews(Long count) {
        views += count;
    }
}
