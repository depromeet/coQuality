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
    public User execute(final Long userId, final User user) {
        return userPort.update(userId, user);
    }
}
