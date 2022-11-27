package com.depromeet.coquality.inner.comment.application;

import com.depromeet.coquality.inner.comment.domain.Comment;
import com.depromeet.coquality.inner.comment.port.driven.CommentPort;
import com.depromeet.coquality.inner.comment.port.driving.ReadCommentsUserCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReadCommentsService implements ReadCommentsUserCase {

    private final CommentPort commentPort;

    @Transactional
    @Override
    public List<Comment> execute(final Long postId) {
        return commentPort.fetch(postId);
    }
}
