package com.depromeet.coquality.inner.user.port.driving;


import com.depromeet.coquality.inner.user.port.driving.dto.request.SignUpDto;

public interface SignUpUserUseCase {
    Long execute(SignUpDto signUpDto);
}
