package com.depromeet.coquality.outer.bookmark.adapter.driving.web;

import com.depromeet.coquality.inner.bookmark.port.driving.CheckBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.port.driving.CreateBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.port.driving.DeleteAllBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.port.driving.DeleteBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.port.driving.ModifyBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.port.driving.ReadBookmarkPostsUseCase;
import com.depromeet.coquality.outer.bookmark.adapter.driving.web.request.BookmarkRequest;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    private final CreateBookmarkUseCase createBookmarkUseCase;
    private final DeleteBookmarkUseCase deleteBookmarkUseCase;
    private final ModifyBookmarkUseCase modifyBookmarkUseCase;
    private final ReadBookmarkPostsUseCase readBookmarkPostsUseCase;
    private final DeleteAllBookmarkUseCase deleteAllBookmarkUseCase;
    private final CheckBookmarkUseCase checkBookmarkUseCase;

    @Auth
    @PostMapping("/{id}")
    public ApiResponse createBookmark(@UserId final Long userId, @PathVariable("id") final Long postId){
        return ApiResponse.success(createBookmarkUseCase.execute(userId, postId));
    }

    @Auth
    @GetMapping("/{id}/check")
    public ApiResponse checkBookmark(@UserId final Long userId, @PathVariable("id") final Long postId){
        return ApiResponse.success(checkBookmarkUseCase.execute(userId, postId));
    }

    @Auth
    @DeleteMapping("/{id}")
    public void deleteBookmark(@UserId final Long userId, @PathVariable("id") final Long postId){
        deleteBookmarkUseCase.execute(userId, postId);
    }

    @PutMapping("/{id}")
    public void putBookmark(@PathVariable("id") final Long bookmarkId, @RequestBody @Valid final BookmarkRequest request){
        modifyBookmarkUseCase.execute(bookmarkId, request.toBookmarkDto());
    }

    @Auth
    @GetMapping("/")
    public ApiResponse getBookmarkPosts(@UserId final Long userId){
       return ApiResponse.success(readBookmarkPostsUseCase.execute(userId));
    }

    @Auth
    @DeleteMapping("/all")
    public void deleteAllBookmarks(@UserId final Long userId){
        deleteAllBookmarkUseCase.execute(userId);
    }

}
