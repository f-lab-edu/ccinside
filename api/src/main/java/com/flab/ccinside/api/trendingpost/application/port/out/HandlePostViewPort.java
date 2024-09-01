package com.flab.ccinside.api.trendingpost.application.port.out;

import com.flab.ccinside.api.trendingpost.adapter.out.persistence.post.PostId;
import com.flab.ccinside.api.trendingpost.domain.Post;

public interface HandlePostViewPort {

  void addViewCount(PostId postId);

  Integer getView(PostId postId);

}
