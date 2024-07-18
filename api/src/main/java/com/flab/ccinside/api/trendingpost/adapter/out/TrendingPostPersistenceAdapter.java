package com.flab.ccinside.api.trendingpost.adapter.out;

import com.flab.ccinside.api.trendingpost.application.port.out.PublishTrendingPostPort;
import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
class TrendingPostPersistenceAdapter implements PublishTrendingPostPort {

  private final TrendingPostJpaRepository trendingPostRepository;
  private final TrendingPostMapper trendingPostMapper;

  @Override
  public void publishTrendingPosts(TrendingPost trendingPost) {
    // 맵퍼로 JPA Entity로 맵핑하여 저장
  }
}
