package com.flab.ccinside.api.trendingpost.application.port.out;

import com.flab.ccinside.api.trendingpost.domain.Post;
import java.util.List;

public interface LoadPostPort {
  List<Post> loadPosts(Long galleryNo);
  List<Post> loadPosts(Long galleryNo, UnitTime unitTime);

}
