package com.depromeet.coquality.inner.user.port.driving;

import com.depromeet.coquality.inner.user.port.driving.dto.request.UserDto;

public interface ModifyUserUseCase {
    void execute(final Long userId, UserDto user);
}
