package com.depromeet.coquality.inner.user.apllication.service;

import com.depromeet.coquality.inner.rank.application.service.RankUseCaseService;
import com.depromeet.coquality.inner.user.port.driven.UserPort;
<<<<<<< HEAD:src/main/java/com/depromeet/coquality/inner/user/apllication/service/ReadUserService.java
import com.depromeet.coquality.inner.user.port.driving.ReadUserUserCase;
import com.depromeet.coquality.inner.user.vo.UserResponse;
=======
import com.depromeet.coquality.inner.user.port.driving.ReadUserUseCase;
>>>>>>> main:src/main/java/com/depromeet/coquality/inner/user/apllication/service/ReadUserServiceUse.java
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReadUserServiceUse implements ReadUserUseCase {
    private final UserPort userPort;
    private final RankUseCaseService rankUseCaseService;


    @Override
    public UserResponse execute(Long userId) {
        rankUseCaseService.achieveProfessionalEditor(userId);
        return userPort.fetch(userId);
    }
}
