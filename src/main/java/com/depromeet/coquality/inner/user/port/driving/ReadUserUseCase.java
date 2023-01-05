package com.depromeet.coquality.inner.user.port.driving;

import com.depromeet.coquality.inner.user.vo.UserResponse;

public interface ReadUserUserCase {
    UserResponse execute(final Long userId);
}
