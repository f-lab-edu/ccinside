package com.flab.ccinside.api.trendingpost.adapter.out.persistence;

import com.flab.ccinside.api.trendingpost.application.port.out.PublishTrendingPostPort;
import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.util.List;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
class TrendingPostPersistenceAdapter implements PublishTrendingPostPort {

  private final TrendingPostJpaRepository trendingPostRepository;
  private final TrendingPostMapper trendingPostMapper;

  @Override
  public void publishTrendingPosts(List<TrendingPost> trendingPost) {
    var entities = trendingPostMapper.mapToEntity(trendingPost);
    trendingPostRepository.saveAll(entities);
  }
}
