package com.depromeet.coquality.outer.user.adapter.driving.web;

import com.depromeet.coquality.inner.user.port.driving.ModifyUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.ReadMyUseCase;
import com.depromeet.coquality.inner.user.port.driving.ReadUserUseCase;
import com.depromeet.coquality.inner.user.port.driving.ValidateNicknameUseCase;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import com.depromeet.coquality.outer.user.adapter.driving.web.dto.reqeust.ModifyUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final ReadMyUseCase readMyUseCase;
    private final ModifyUserUseCase modifyUserUseCase;
    private final ValidateNicknameUseCase validateNicknameUseCase;
    private final ReadUserUseCase readUserUseCase;


    @Auth
    @GetMapping("/read")
    public ApiResponse readMyInfo(@UserId final Long userId) {
        return ApiResponse.success(readMyUseCase.execute(userId));
    }

    @Auth
    @PutMapping("/update")
    public void modifyUser(@UserId final Long userId, @RequestBody @Valid final ModifyUserRequest request){
        modifyUserUseCase.execute(userId, request.toUserDto());
    }

    @GetMapping("/exist")
    public ApiResponse existNickname(final @RequestParam String nickname){
        return ApiResponse.success(validateNicknameUseCase.execute(nickname));
    }
    @GetMapping("/{id}/read")
    public ApiResponse readUserInfo(final Long userId) {
        return ApiResponse.success(readUserUseCase.execute(userId));
    }
}
