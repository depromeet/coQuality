package com.depromeet.coquality.outer.post.entity;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.inner.post.vo.PostDetailResponse;
import com.depromeet.coquality.inner.post.vo.PostResponse;
import com.depromeet.coquality.outer.common.entity.BaseEntity;
import java.net.URI;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = PostEntity.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostEntity extends BaseEntity {

    public static final String TABLE_NAME = "posts";

    private String title;
    private String contents;
    private String thumbnail;
    @Enumerated(value = EnumType.STRING)
    private PrimaryPostCategoryCode primaryCategory;
    @Enumerated(value = EnumType.STRING)
    private PostStatusCode postStatusCode;
    private String summary;
    private Long views;
    private Long clapCount;

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
        @NonNull Long clapCount,
        @NonNull Long userId
    ) {
        this.title = title;
        this.contents = contents;
        this.thumbnail = thumbnail;
        this.primaryCategory = primaryCategory;
        this.postStatusCode = postStatusCode;
        this.summary = summary;
        this.views = views;
        this.clapCount = clapCount;
        this.userId = userId;
    }

    public static PostEntity from(Post post) {
        final var thumbnail = convertURIToString(post.getThumbnail());

        return PostEntity.factory()
            .title(post.getTitle())
            .userId(post.getUserId())
            .contents(post.getContents())
            .thumbnail(thumbnail)
            .primaryCategory(post.getPrimaryCategory())
            .postStatusCode(post.getPostStatusCode())
            .summary(post.getSummary())
            .views(post.getViews())
            .clapCount(post.getClapCount())
            .newInstance();
    }

    public PostResponse toPostResponse(String userName, Long commentCount,
        Set<String> tags) {
        return PostResponse.of(
            getId(),
            userId,
            userName,
            title,
            convertStringToURI(thumbnail),
            primaryCategory,
            postStatusCode,
            summary,
            views,
            commentCount,
            tags,
            clapCount,
            getCreatedAt()
        );
    }

    public PostDetailResponse toPostDetailResponse(Set<String> tags, String userName,
        Long commentCount, boolean bookmarkYn) {
        return PostDetailResponse.of(
            getId(),
            userId,
            title,
            contents,
            userName,
            convertStringToURI(thumbnail),
            primaryCategory,
            postStatusCode,
            summary,
            views,
            commentCount,
            tags,
            clapCount,
            bookmarkYn,
            getCreatedAt()
        );
    }

    public Post toPost() {
        return Post.of(
            getId(),
            userId,
            title,
            contents,
            convertStringToURI(thumbnail),
            primaryCategory,
            postStatusCode,
            summary,
            views,
            clapCount
        );
    }

    public PostEntity modifyTitle(@NonNull String title) {
        this.title = title;
        return this;
    }

    public PostEntity modifyContents(@NonNull String contents) {
        this.contents = contents;
        return this;
    }

    public PostEntity modifyThumbnail(URI thumbnail) {
        this.thumbnail = convertURIToString(thumbnail);
        return this;
    }

    public PostEntity changePrimaryPostCategoryCode(
        @NonNull PrimaryPostCategoryCode primaryCategory) {
        this.primaryCategory = primaryCategory;
        return this;
    }

    public PostEntity changePostStatusCode(@NonNull PostStatusCode postStatusCode) {
        this.postStatusCode = postStatusCode;
        return this;
    }

    public PostEntity modifySummary(@NonNull String summary) {
        this.summary = summary;
        return this;
    }

    public PostEntity modifyClapCount(@NonNull Long clapCount) {
        this.clapCount = clapCount;
        return this;
    }

    public PostEntity increaseViews(Long count) {
        views += count;
        return this;
    }

    private static URI convertStringToURI(String str) {
        return str == null ? null : URI.create(str);
    }

    private static String convertURIToString(URI uri) {
        return uri == null ? null : String.valueOf(uri);
    }
}
