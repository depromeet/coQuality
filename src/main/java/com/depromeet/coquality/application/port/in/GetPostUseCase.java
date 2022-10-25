package com.depromeet.coquality.application.port.in;

import com.depromeet.coquality.application.port.in.dto.response.PostResponse;

public interface GetPostUseCase {
    PostResponse getPost(String title);
}
