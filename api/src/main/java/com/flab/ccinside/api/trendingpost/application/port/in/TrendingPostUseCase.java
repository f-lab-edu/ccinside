package com.flab.ccinside.api.trendingpost.application.port.in;

import com.flab.ccinside.api.trendingpost.application.port.out.TrendingPostData;
import java.util.List;

public interface TrendingPostUseCase {

  void publishNewTrendingPosts(PublishTrendingPostCommand command);

  List<TrendingPostData> getTrendingPosts();

  void addOnePostIntoTrendingList(Long postNo);

  void deleteTrendingPost(Long postNo);
}
