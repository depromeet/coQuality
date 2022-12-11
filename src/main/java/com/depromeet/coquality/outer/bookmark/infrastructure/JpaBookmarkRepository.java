package com.depromeet.coquality.outer.bookmark.infrastructure;

import com.depromeet.coquality.outer.bookmark.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
}
