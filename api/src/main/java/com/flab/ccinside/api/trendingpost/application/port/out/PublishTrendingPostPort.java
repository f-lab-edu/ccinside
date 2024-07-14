package com.flab.ccinside.api.trendingpost.application.port.out;

import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.util.List;

public interface PublishTrendingPostPort {

  void publishTrendingPosts(TrendingPost trendingPost);

}
