package com.depromeet.coquality.outer.post.adapter.driving.web;

import com.depromeet.coquality.inner.post.application.code.PostSortCode;
import com.depromeet.coquality.inner.post.domain.code.PostStatusCode;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.inner.post.port.driving.DeletePostUseCase;
import com.depromeet.coquality.inner.post.port.driving.IssuePostUseCase;
import com.depromeet.coquality.inner.post.port.driving.ModifyPostUseCase;
import com.depromeet.coquality.inner.post.port.driving.ReadPostDetailUseCase;
import com.depromeet.coquality.inner.post.port.driving.ReadPostsUseCase;
import com.depromeet.coquality.inner.post.vo.PostsReadInfo;
import com.depromeet.coquality.outer.post.adapter.driving.web.request.IssuePostRequest;
import com.depromeet.coquality.outer.post.adapter.driving.web.request.ModifyPostRequest;
import com.depromeet.coquality.outer.post.adapter.driving.web.response.PostResponse;
import com.depromeet.coquality.outer.post.adapter.driving.web.response.PostsResponse;
import java.util.Set;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final IssuePostUseCase issuePostUseCase;
    private final ReadPostDetailUseCase readPostDetailUseCase;
    private final ReadPostsUseCase readPostsUseCase;
    private final ModifyPostUseCase modifyPostUseCase;
    private final DeletePostUseCase deletePostUseCase;

    @PostMapping
    public void issuePost(
        @Valid @RequestBody final IssuePostRequest issuePostRequest) {
        final var post = issuePostRequest.toPost();

        issuePostUseCase.execute(post);
    }

    @GetMapping("/{id}")
    public PostResponse readPostDetail(@PathVariable final Long id) {
        final var post = readPostDetailUseCase.execute(id);
        return new PostResponse(post);
    }

    @GetMapping
    public PostsResponse readPosts(
        @RequestParam PostSortCode sort,
        @RequestParam(required = false) PrimaryPostCategoryCode primaryCategory
    ) {
        final var postReadInfo = new PostsReadInfo(sort, primaryCategory,
            Set.of(PostStatusCode.ISSUED));

        final var posts = readPostsUseCase.execute(postReadInfo);

        return new PostsResponse(posts);
    }

    @PutMapping("/{id}")
    public void modifyPost(@PathVariable final Long id,
        @RequestBody ModifyPostRequest modifyPostRequest) {
        final var post = modifyPostRequest.toPost(id);

        modifyPostUseCase.execute(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable final Long id) {
        deletePostUseCase.execute(id);
    }

}
