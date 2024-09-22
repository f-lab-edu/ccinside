package com.flab.ccinside.api.trendingpost.adapter.out.post.persistence;

import java.util.List;

public interface PostRepositorySupport {

  void saveAllByBatch(List<PostEntity> posts);
}
