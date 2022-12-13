package com.depromeet.coquality.outer.bookmark.adapter.driven.persistence;

import com.depromeet.coquality.inner.bookmark.domain.Bookmark;
import com.depromeet.coquality.inner.bookmark.port.driven.BookmarkPort;
import com.depromeet.coquality.inner.bookmark.vo.BookmarkPostResponse;
import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.outer.bookmark.entity.BookmarkEntity;
import com.depromeet.coquality.outer.bookmark.infrastructure.JpaBookmarkRepository;
import com.depromeet.coquality.outer.post.entity.PostEntity;
import com.depromeet.coquality.outer.post.infrastructure.JpaPostRepository;
import com.depromeet.coquality.outer.user.entity.UserEntity;
import com.depromeet.coquality.outer.user.infrastructure.JpaUserRepository;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaBookmarkAdapter implements BookmarkPort {

    private final JpaBookmarkRepository jpaBookmarkRepository;
    private final JpaPostRepository jpaPostRepository;
    private final JpaUserRepository jpaUserRepository;

    @Override
    public Long save(final Bookmark bookmark) {

        jpaPostRepository.findById(bookmark.getPostId())
                .orElseThrow(CoQualityDomainExceptionCode.POST_ENTITY_IS_NULL::newInstance);

        final BookmarkEntity saveBookmarkEntity = BookmarkEntity.factory()
                .userId(bookmark.getUserId())
                .postId(bookmark.getPostId())
                .description(bookmark.getDescription())
                .newInstance();
        jpaBookmarkRepository.save(saveBookmarkEntity);
        return saveBookmarkEntity.getId();
    }

    @Override
    public void delete(final Bookmark bookmark) {
        final BookmarkEntity findBookmarkEntity = jpaBookmarkRepository.findBookmarkByUserIdAndPostId(
                        bookmark.getUserId(),
                        bookmark.getPostId())
                .orElseThrow(CoQualityDomainExceptionCode.BOOKMARK_ENTITY_IS_NULL::newInstance);
        jpaBookmarkRepository.delete(findBookmarkEntity);
    }

    @Override
    public void changeBookmark(final Long bookmarkId, final String description) {
        final BookmarkEntity findBookmarkEntity = jpaBookmarkRepository.findById(bookmarkId)
                .orElseThrow(CoQualityDomainExceptionCode.BOOKMARK_ENTITY_IS_NULL::newInstance);

        findBookmarkEntity.changeBookmarkDescription(description);
        jpaBookmarkRepository.save(findBookmarkEntity);
    }

    @Override
    public List<BookmarkPostResponse> readBookmarkPosts(final Long userId) {
        final List<BookmarkEntity> findBookmarks = jpaBookmarkRepository.findBookmarkByUserId(userId);

        final List<Long> bookmarkPostIds = findBookmarks
                .stream()
                .map(BookmarkEntity::getPostId)
                .toList();

        final List<PostEntity> findPosts = jpaPostRepository.findAllById(bookmarkPostIds);

        return findPosts
                .stream()
                .map(p -> {
                    final var findUserEntity = jpaUserRepository.findById(p.getUserId())
                            .orElseThrow(CoQualityDomainExceptionCode.USER_ENTITY_IS_NULL::newInstance);
                    final var findBookmarkEntity = jpaBookmarkRepository.findBookmarkByUserIdAndPostId(
                                    findUserEntity.getId(),
                                    p.getId())
                            .orElseThrow(CoQualityDomainExceptionCode.POST_ENTITY_IS_NULL::newInstance);

                    return BookmarkPostResponse.of(
                            p.getId(),
                            p.getTitle(),
                            findUserEntity.getNickname(),
                            p.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            p.getThumbnail(),
                            findBookmarkEntity.getDescription()
                    );
                })
                .collect(Collectors.toList());
    }
}
