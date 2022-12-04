package com.depromeet.coquality.inner.follow.port.driving;

public interface CreateFollowUseCase {
    void execute(Long fromUserId, Long toUserId);
}
