package com.depromeet.coquality.inner.user.port.driving;

import com.depromeet.coquality.inner.user.vo.UserResponse;

public interface ReadUserUseCase {
    UserResponse execute(final Long userId);
}
