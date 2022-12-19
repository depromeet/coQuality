package com.depromeet.coquality.outer.tag.entity;

import com.depromeet.coquality.inner.tag.domain.Tag;
import com.depromeet.coquality.outer.common.entity.BaseEntity;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = TagEntity.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TagEntity extends BaseEntity {

    public static final String TABLE_NAME = "tags";

    private Long postId;
    private Long userId;
    private String tagValue;

    private TagEntity(
        @NonNull Long postId,
        @NonNull Long userId,
        @NonNull String tagValue) {
        this.postId = postId;
        this.userId = userId;
        this.tagValue = tagValue;
    }

    public static TagEntity from(Tag tag) {
        return new TagEntity(
            tag.getPostId(),
            tag.getUserId(),
            tag.getTagValue()
        );
    }
}
