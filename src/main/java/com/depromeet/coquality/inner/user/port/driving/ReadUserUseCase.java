package com.depromeet.coquality.inner.user.port.driving;

import com.depromeet.coquality.inner.user.domain.User;

public interface ReadUserUseCase {
    User execute(final Long userId);
}
