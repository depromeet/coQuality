package com.depromeet.coquality.outer.comment.entity;

import com.depromeet.coquality.outer.common.entity.BaseEntity;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = CommentEntity.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommentEntity extends BaseEntity {
    public static final String TABLE_NAME = "comments";

    @Column(length = 200)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // TODO, mapped when postEntity is ready
    private Long postId;

    private LocalDateTime deletedAt;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private CommentEntity(Long id, String contents, UserEntity user, Long postId) {
        this.contents = contents;
        this.user = user;
        this.postId = postId;
        this.deletedAt = null;
    }
}
