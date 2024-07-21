package com.flab.ccinside.api.trendingpost.application.port.out;

import java.util.List;

public interface LoadPostPort {
  List<PostData> loadPosts(Long galleryNo);
  List<PostData> loadPosts(Long galleryNo, UnitTime unitTime);

}
