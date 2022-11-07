package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driving.IssuePostUseCase;
import com.depromeet.coquality.inner.post.port.driving.ReadPostUseCase;
import com.depromeet.coquality.outer.post.adapter.driving.web.request.IssuePostRequest;
import com.depromeet.coquality.outer.post.adapter.driving.web.response.PostResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final IssuePostUseCase issuePostUseCase;
    private final ReadPostUseCase readPostUseCase;

    @PostMapping
    public void issuePost(
        @Valid @RequestBody final IssuePostRequest issuePostRequest) {
        final var post = Post.of(
            issuePostRequest.title(),
            issuePostRequest.contents(),
            issuePostRequest.primaryPostCategoryCode(),
            issuePostRequest.summary()
        );
        issuePostUseCase.execute(post);
    }

    @GetMapping("/{id}")
    public PostResponse readPost(@PathVariable final Long id) {
        Post post = readPostUseCase.execute(id);
        return new PostResponse(post);
    }

}
