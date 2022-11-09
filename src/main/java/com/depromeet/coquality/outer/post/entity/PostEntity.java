package com.depromeet.coquality.outer.post.entity;

import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.outer.common.entity.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
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
    @Enumerated(value = EnumType.STRING)
    private PrimaryPostCategoryCode primaryPostCategoryCode;
    private String summary;
    private Long views;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private PostEntity(
        @NonNull String title,
        @NonNull String contents,
        @NonNull PrimaryPostCategoryCode primaryPostCategoryCode,
        @NonNull String summary,
        @NonNull Long views
    ) {
        this.title = title;
        this.contents = contents;
        this.primaryPostCategoryCode = primaryPostCategoryCode;
        this.summary = summary;
        this.views = views;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setContents(@NonNull String contents) {
        this.contents = contents;
    }

    public void setPrimaryPostCategoryCode(
        @NonNull PrimaryPostCategoryCode primaryPostCategoryCode) {
        this.primaryPostCategoryCode = primaryPostCategoryCode;
    }

    public void setSummary(@NonNull String summary) {
        this.summary = summary;
    }

    public void increaseViews(@Min(1) Long count) {
        views += count;
    }
}
