package com.flab.ccinside.api.trendingpost.application.port.in;

import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import java.util.List;

public interface TrendingPostUseCase {

  void publishNewTrendingPosts();

  List<PostData> getTrendingPosts();

  void updateTrendingPosts();
}
