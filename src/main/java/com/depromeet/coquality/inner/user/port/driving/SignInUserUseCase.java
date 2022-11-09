package com.depromeet.coquality.inner.user.port.driving;

import com.depromeet.coquality.inner.user.port.driving.dto.request.LoginDto;

public interface SignInUserUseCase {
    Long execute(LoginDto loginDto);
}
