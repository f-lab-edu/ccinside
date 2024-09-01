package com.flab.ccinside.api.trendingpost.application.port.out.post;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;

public interface HandlePostViewPort {

  void addViewCount(PostId postId);

  Integer getView(PostId postId);
}
