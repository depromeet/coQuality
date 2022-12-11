package com.depromeet.coquality.inner.follow.port.driving;

public interface DeleteFollowUseCase {
    void execute(Long fromUserId, Long toUserId);
}
