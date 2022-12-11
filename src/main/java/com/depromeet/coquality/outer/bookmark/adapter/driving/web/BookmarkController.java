package com.depromeet.coquality.outer.bookmark.adapter.driving.web;

import com.depromeet.coquality.inner.bookmark.port.driving.CreateBookmarkUseCase;
import com.depromeet.coquality.inner.bookmark.port.driving.DeleteBookmarkUseCase;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    private final CreateBookmarkUseCase createBookmarkUseCase;
    private final DeleteBookmarkUseCase deleteBookmarkUseCase;

    @Auth
    @PostMapping("/{id}")
    public ApiResponse createBookmark(@UserId final Long userId, @PathVariable("id") final Long postId){
        return ApiResponse.success(createBookmarkUseCase.execute(userId, postId));
    }

    @Auth
    @DeleteMapping("/{id}")
    public void deleteBookmark(@UserId final Long userId, @PathVariable("id") final Long postId){
        deleteBookmarkUseCase.execute(userId, postId);
    }
}
