package com.depromeet.coquality.inner.bookmark.vo;

import lombok.Getter;

@Getter
public class BookmarkConditionResponse {
    private boolean condition;

    private BookmarkConditionResponse(final boolean condition) {
        this.condition = condition;
    }
    public static BookmarkConditionResponse of(final boolean condition){
        return new BookmarkConditionResponse(condition);
    }
}
