package com.depromeet.coquality.inner.user.apllication.service;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.inner.user.port.driving.ModifyUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.dto.request.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ModifyUserService implements ModifyUserUseCase {
    private final UserPort userPort;

    @Override
    public void execute(final Long userId, final UserDto user) {
        final User findUser = userPort.fetch(userId);

        findUser.updateUserInfo(
                user.getNickname(),
                user.getSocialEmail(),
                user.getUserSummary()
        );

        userPort.update(userId, findUser);

    }
}
