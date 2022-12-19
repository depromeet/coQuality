package com.depromeet.coquality.outer.bookmark.adapter.driving.web.request;

import com.depromeet.coquality.inner.bookmark.port.driving.dto.BookmarkDto;
import javax.validation.constraints.NotNull;

public record BookmarkRequest(@NotNull String description){
    public BookmarkDto toBookmarkDto(){
        return new BookmarkDto(description);
    }
}
