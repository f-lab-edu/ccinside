package com.flab.ccinside.api.trendingpost.application.port.out.post;

import com.flab.ccinside.api.trendingpost.domain.Post;

public interface CreatePostPort {

  void createPost(Post post);
}
