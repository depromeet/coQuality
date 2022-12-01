package com.depromeet.coquality.outer.user.adapter.driving.web;

import com.depromeet.coquality.inner.user.domain.User;
import com.depromeet.coquality.inner.user.port.driving.ModifyUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.ReadUserUserCase;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust.ModifyUserRequest;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final ReadUserUserCase readUserUserCase;
    private final ModifyUserUseCase modifyUserUseCase;

    @Auth
    @GetMapping("/read")
    public UserResponse readMyInfo(@UserId final Long userId) {
        final User user = readUserUserCase.execute(userId);
        return UserResponse.of(userId, user.getNickname());
    }

    @Auth
    @PutMapping("/update")
    public void modifyUser(@UserId final Long userId, @RequestBody @Valid final ModifyUserRequest request){
        modifyUserUseCase.execute(userId, request.toUserDto());
    }
}
