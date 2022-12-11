package com.depromeet.coquality.inner.bookmark.port.driving;

public interface CreateBookmarkUseCase {
    void execute(Long userId, Long postId);
}
