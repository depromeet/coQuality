package com.depromeet.coquality.inner.bookmark.port.driving;

public interface CreateBookmarkUseCase {
    Long execute(Long userId, Long postId);
}
