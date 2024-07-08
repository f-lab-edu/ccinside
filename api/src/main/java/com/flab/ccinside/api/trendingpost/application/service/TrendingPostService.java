package com.flab.ccinside.api.trendingpost.application.service;

import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TrendingPostService implements TrendingPostUseCase {

  @Override
  public void publishNewTrendingPosts() {

  }

  @Override
  public List<PostData> getTrendingPosts() {
    return null;
  }

  @Override
  public void updateTrendingPosts() {

  }
}
