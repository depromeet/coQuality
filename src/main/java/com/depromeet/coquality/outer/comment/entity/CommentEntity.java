package com.depromeet.coquality.outer.comment.entity;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.vo.CommentResponse;
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

    private Long userId;
    private Long postId;

    private LocalDateTime deletedAt;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private CommentEntity(final String contents, final Long userId, final Long postId) {
        this.contents = contents;
        this.userId = userId;
        this.postId = postId;
        this.deletedAt = null;
    }
    public Comment toComment(){
        return Comment.of(
                getId(),
                this.contents,
                this.userId,
                this.postId
        );
    }
    public CommentResponse toCommentResponse(){
        return CommentResponse.of(
                getId(),
                contents,
                userId,
                postId,
                getCreatedAt()
        );
    }
}
