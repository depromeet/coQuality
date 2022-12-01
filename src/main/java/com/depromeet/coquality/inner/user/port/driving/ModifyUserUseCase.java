package com.depromeet.coquality.inner.user.port.driving;

import com.depromeet.coquality.inner.user.domain.User;

public interface ModifyUserUseCase {
    void execute(final Long userId, User user);
}
