package com.depromeet.coquality.outer.bookmark.infrastructure;

import com.depromeet.coquality.outer.bookmark.entity.BookmarkEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
    Optional<BookmarkEntity> findBookmarkByUserIdAndPostId(Long userId, Long postId);
    List<BookmarkEntity> findBookmarkByUserId(Long userId);
}
