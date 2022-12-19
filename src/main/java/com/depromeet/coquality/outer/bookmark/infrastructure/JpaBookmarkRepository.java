package com.depromeet.coquality.outer.bookmark.infrastructure;

import com.depromeet.coquality.outer.bookmark.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaBookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
    Optional<BookmarkEntity> findBookmarkByUserIdAndPostId(Long userId, Long postId);
    List<BookmarkEntity> findBookmarkByUserId(Long userId);

    @Modifying
    @Query("delete from bookmarks b where b.id in :ids")
    void deleteAllByBookmarkIds(@Param("ids") List<Long> bookmarkPostIds);
}
