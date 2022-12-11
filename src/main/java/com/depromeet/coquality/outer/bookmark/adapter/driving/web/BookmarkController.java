package com.depromeet.coquality.outer.bookmark.adapter.driving.web;

import com.depromeet.coquality.inner.bookmark.port.driving.CreateBookmarkUseCase;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    private final CreateBookmarkUseCase createBookmarkUseCase;

    @Auth
    @PostMapping("/{id}")
    public void createBookmark(@UserId final Long userId, @PathVariable("id") final Long postId){
        createBookmarkUseCase.execute(userId, postId);
    }
}
