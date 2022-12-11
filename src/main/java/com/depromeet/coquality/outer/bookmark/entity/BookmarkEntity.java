package com.depromeet.coquality.outer.bookmark.entity;

import static com.depromeet.coquality.outer.bookmark.entity.BookmarkEntity.TABLE_NAME;

import com.depromeet.coquality.outer.common.entity.BaseEntity;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BookmarkEntity extends BaseEntity {
    public static final String TABLE_NAME = "bookmarks";

    private Long userId;
    private Long postId;
    private String description;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private BookmarkEntity(final Long userId, final Long postId, final String description) {
        this.userId = userId;
        this.postId = postId;
        this.description = description;
    }
}
