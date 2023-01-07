package com.depromeet.coquality.inner.bookmark.vo;

import lombok.Getter;

@Getter
public class BookmarkConditionResponse {
    private boolean bookmarkYn;

    private BookmarkConditionResponse(final boolean bookmarkYn) {
        this.bookmarkYn = bookmarkYn;
    }
    public static BookmarkConditionResponse of(final boolean bookmarkYn){
        return new BookmarkConditionResponse(bookmarkYn);
    }
}
