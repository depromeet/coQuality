package com.depromeet.coquality.inner.user.apllication.service;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.inner.user.port.driving.ReadUserUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReadUserService implements ReadUserUserCase {
    private final UserPort userPort;


    @Override
    public User execute(Long userId) {
        return userPort.fetch(userId);
    }
}
