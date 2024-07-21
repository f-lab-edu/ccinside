package com.flab.ccinside.api.trendingpost.adapter.out.persistence;

import com.flab.ccinside.api.trendingpost.application.port.out.TrendingPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.util.List;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
class TrendingPostPersistenceAdapter implements TrendingPostPort {

  private final TrendingPostJpaRepository trendingPostRepository;
  private final TrendingPostJpaMapper trendingPostJpaMapper;

  @Override
  public void publishTrendingPosts(List<TrendingPost> trendingPost) {
    var entities = trendingPostJpaMapper.mapToEntity(trendingPost);
    trendingPostRepository.saveAll(entities);
  }

  @Override
  public List<TrendingPost> getTrendingPosts(Long galleryNo, UnitTime unitTime) {
    var trendingPosts = trendingPostRepository.findByGalleryNo(galleryNo);
    return trendingPostJpaMapper.mapToDomain(trendingPosts);
  }
}
