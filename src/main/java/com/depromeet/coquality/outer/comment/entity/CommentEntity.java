package com.depromeet.coquality.outer.comment.entity;

import com.depromeet.coquality.outer.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = CommentEntity.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommentEntity extends BaseEntity {
    public static final String TABLE_NAME = "comments";

    @Column(length = 200)
    private String contents;

    // TODO, mapped when userEntity is ready
    private Long userId;

    // TODO, mapped when postEntity is ready
    private Long postId;

    private LocalDateTime deletedAt;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private CommentEntity(Long id, String contents, Long userId, Long postId) {
        this.contents = contents;
        this.userId = userId;
        this.postId = postId;
        this.deletedAt = null;
    }
}
