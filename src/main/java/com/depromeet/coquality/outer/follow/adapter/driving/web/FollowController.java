package com.depromeet.coquality.outer.follow.adapter.driving.web;

import com.depromeet.coquality.inner.follow.port.driving.CreateFollowUseCase;
import com.depromeet.coquality.inner.follow.port.driving.DeleteFollowUseCase;
import com.depromeet.coquality.inner.follow.port.driving.GetFollowCountUserCase;
import com.depromeet.coquality.outer.common.vo.ApiResponse;
import com.depromeet.coquality.outer.interceptor.Auth;
import com.depromeet.coquality.outer.resolver.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/follows")
public class FollowController {

    private final CreateFollowUseCase createFollowUseCase;
    private final DeleteFollowUseCase deleteFollowUseCase;

    @PostMapping("/{id}")
    @Auth
    public void createFollow(@UserId final Long fromUserId, @PathVariable("id") final Long toUserId){
        createFollowUseCase.execute(fromUserId, toUserId);
    }

    @DeleteMapping("/{id}")
    @Auth
    public void deleteFollow(@UserId final Long fromUserId, @PathVariable("id") final Long toUserId){
        deleteFollowUseCase.execute(fromUserId, toUserId);
    }
