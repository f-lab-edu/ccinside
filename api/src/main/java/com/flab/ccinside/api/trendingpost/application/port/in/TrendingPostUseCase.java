package com.flab.ccinside.api.trendingpost.application.port.in;

import com.flab.ccinside.api.trendingpost.application.port.out.TrendingPostData;
import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import java.util.List;

public interface TrendingPostUseCase {

  void publishNewTrendingPosts(PublishTrendingPostCommand command);

  List<TrendingPostData> getTrendingPosts(Long galleryNo, UnitTime unitTime);

  void addOnePostIntoTrendingList(Long postNo);

  void deleteTrendingPost(Long postNo);
}
