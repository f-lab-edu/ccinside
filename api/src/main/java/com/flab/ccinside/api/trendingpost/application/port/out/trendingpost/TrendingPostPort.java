package com.flab.ccinside.api.trendingpost.application.port.out.trendingpost;

import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.util.List;

public interface TrendingPostPort {

  void publishTrendingPosts(List<TrendingPost> trendingPost);

  List<TrendingPost> getTrendingPosts(Long galleryNo, UnitTime unitTime);
}
