package com.depromeet.coquality.inner.post.port.driving;

import com.depromeet.coquality.inner.post.vo.ModifyPostCommand;

public interface ModifyPostUseCase {

    void execute(Long userId, Long postId, ModifyPostCommand post);
}
