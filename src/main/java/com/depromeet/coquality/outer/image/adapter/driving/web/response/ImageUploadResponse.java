package com.depromeet.coquality.outer.image.adapter.driving.web.response;

import lombok.NonNull;

public record ImageUploadResponse(
    @NonNull String url,
    @NonNull String originalFileName
) {

}
