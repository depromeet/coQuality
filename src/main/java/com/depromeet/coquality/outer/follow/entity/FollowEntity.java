package com.depromeet.coquality.outer.follow.entity;


import com.depromeet.coquality.outer.common.entity.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FollowEntity extends BaseEntity {

    private Long fromUserId;
    private Long toUserId;

    @Builder(builderMethodName = "factory", buildMethodName = "newInstance")
    public FollowEntity(final Long fromUserId, final Long toUserId) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
    }

}
