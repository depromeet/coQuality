package com.depromeet.coquality.outer.comment.entity;

import com.depromeet.coquality.outer.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = CommentEntity.TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommentEntity extends BaseEntity {
    public static final String TABLE_NAME = "comments";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String contents;

    // TODO, mapped when userEntity is ready
    private Long userId;

    // TODO, mapped when postEntity is ready
    private Long postId;

    private final LocalDateTime deletedAt = null;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    private CommentEntity(Long id, String contents, Long userId, Long postId) {
        this.id = id;
        this.contents = contents;
        this.userId = userId;
        this.postId = postId;
    }
}
