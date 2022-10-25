package com.depromeet.coquality.application.port.in;

import com.depromeet.coquality.application.port.in.dto.request.PostRequest;
import com.depromeet.coquality.application.port.in.dto.response.PostResponse;

public interface SavePostUseCase {
    PostResponse savePost(PostRequest postRequest);
}
