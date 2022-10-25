package com.depromeet.coquality.adapter.in.presentation;

import com.depromeet.coquality.adapter.in.presentation.dto.CreatePostDTO;
import com.depromeet.coquality.application.port.in.GetPostUseCase;
import com.depromeet.coquality.application.port.in.SavePostUseCase;
import com.depromeet.coquality.application.port.in.dto.request.PostRequest;
import com.depromeet.coquality.application.port.in.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final SavePostUseCase savePostUseCase;
    private final GetPostUseCase getPostUseCase;

    @PostMapping("/post")
    public void savePost(@Valid @RequestBody final CreatePostDTO createPostDTO) {
        savePostUseCase.savePost(new PostRequest(createPostDTO.getTitle(), createPostDTO.getDescription()));
    }

    @GetMapping("/post/{title}")
    public PostResponse getPost(@PathVariable String title) {
        return getPostUseCase.getPost(title);
    }
}
