package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.vo.PostDetailResponse;

public interface ReadPostDetailUseCase {

    PostDetailResponse execute(final Long id);
}
