package com.flab.ccinside.api.trendingpost.application.port.out.post;

import com.flab.ccinside.api.trendingpost.domain.Post;
import java.util.List;

public interface PersistPostViewPort {

  void modify(Post post);

  void modifyInBatch(List<Post> posts);
}
