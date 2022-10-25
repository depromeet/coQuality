package com.depromeet.coquality.adapter.out.infrastructcture.persistance;

import com.depromeet.coquality.application.port.out.GetPostPort;
import com.depromeet.coquality.application.port.out.PostDetail;
import com.depromeet.coquality.application.port.out.SavePostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PostAdapter implements SavePostPort, GetPostPort {
    private final PostRepository postRepository;

    @Override
    public void savePost(final PostDetail postDetail) {
        postRepository.save(PostEntity.newInstance(postDetail));
    }


    @Override
    public PostDetail getPost(final String title) {
        final PostEntity post = postRepository.findByTitle(title).orElseThrow(IllegalAccessError::new);
        return PostDetail.of(post.getTitle(), post.getDescription());
    }


}
