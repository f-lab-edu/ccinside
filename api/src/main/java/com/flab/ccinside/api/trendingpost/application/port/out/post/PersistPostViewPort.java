package com.flab.ccinside.api.trendingpost.application.port.out.post;

import com.flab.ccinside.api.trendingpost.domain.Post;

public interface PersistPostViewPort {

  void modify(Post post);
}
