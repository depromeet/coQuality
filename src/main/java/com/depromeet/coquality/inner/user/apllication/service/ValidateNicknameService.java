package com.depromeet.coquality.inner.user.apllication.service;

import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.inner.user.port.driving.ValidateNicknameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ValidateNicknameService implements ValidateNicknameUseCase {

    private final UserPort userPort;

    @Override
    public boolean execute(final String nickname) {
        return userPort.existNickname(nickname);
    }
}
