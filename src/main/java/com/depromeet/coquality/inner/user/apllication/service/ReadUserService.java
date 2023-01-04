package com.depromeet.coquality.inner.user.apllication.service;

import com.depromeet.coquality.inner.rank.application.service.RankUseCaseService;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
import com.depromeet.coquality.inner.user.port.driving.ReadUserUserCase;
import com.depromeet.coquality.inner.user.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReadUserService implements ReadUserUserCase {
    private final UserPort userPort;
    private final RankUseCaseService rankUseCaseService;


    @Override
    public UserResponse execute(Long userId) {
        rankUseCaseService.achieveProfessionalEditor(userId);
        return userPort.fetch(userId);
    }
}
