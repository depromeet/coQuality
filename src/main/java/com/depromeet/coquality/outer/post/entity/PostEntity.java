package com.depromeet.coquality.outer.post.entity;

import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "Post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String contents;
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
}
