package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.port.driving.DeletePostUseCase;
import com.depromeet.coquality.inner.post.port.driving.IssuePostUseCase;
import com.depromeet.coquality.inner.post.port.driving.ModifyPostUseCase;
import com.depromeet.coquality.inner.post.port.driving.ReadPostUseCase;
import com.depromeet.coquality.outer.post.adapter.driving.web.request.IssuePostRequest;
import com.depromeet.coquality.outer.post.adapter.driving.web.request.ModifyPostRequest;
import com.depromeet.coquality.outer.post.adapter.driving.web.response.PostResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final IssuePostUseCase issuePostUseCase;
    private final ReadPostUseCase readPostUseCase;
    private final ModifyPostUseCase modifyPostUseCase;
    private final DeletePostUseCase deletePostUseCase;

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
        final var post = readPostUseCase.execute(id);
        return new PostResponse(post);
    }

    @PutMapping("/{id}")
    public void modifyPost(@PathVariable final Long id,
        @RequestBody ModifyPostRequest modifyPostRequest) {

        final var post = Post.of(
            modifyPostRequest.title(),
            modifyPostRequest.contents(),
            modifyPostRequest.primaryPostCategoryCode(),
            modifyPostRequest.summary(),
            modifyPostRequest.views()
        );

        modifyPostUseCase.execute(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable final Long id) {
        deletePostUseCase.execute(id);
    }

}
