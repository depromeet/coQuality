package com.depromeet.coquality.inner.user.apllication.service;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.inner.user.port.driving.ModifyUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ModifyUserService implements ModifyUserUseCase {
    private final UserPort userPort;

    @Override
    public void execute(Long userId, User user) {
        userPort.update(userId, user);
    }
}
