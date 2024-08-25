package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.in.CreatePostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.PostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.CreatePostPort;
import com.flab.ccinside.api.trendingpost.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostUserService implements PostUseCase {

  private final CreatePostPort createPostPort;

  @Override
  public void create(CreatePostCommand command) {
    var post = Post.createWithoutId(command);
    createPostPort.createPost(post);
  }
}
