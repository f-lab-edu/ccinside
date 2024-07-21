package com.flab.ccinside.api.trendingpost.adapter.out.persistence;

import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class TrendingPostJpaMapper {

  List<TrendingPostEntity> mapToEntity(List<TrendingPost> trendingPosts) {
    return trendingPosts.stream()
                                .map(m -> new TrendingPostEntity(
                                    m.getPostNo(),
                                    m.getPostTitle(),
                                    m.getAuthorNo(),
                                    m.getGalleryNo(),
                                    m.getPostViews(),
                                    m.getCommentCount(),
                                    m.getUnitTime(),
                                    LocalDateTime.parse(m.getCreatedAt(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                                ))
                                .toList();
  }

  List<TrendingPost> mapToDomain(List<TrendingPostEntity> trendingPosts) {
    return trendingPosts.stream().map(
        m -> new TrendingPost(
            m.getId(),
            m.getTitle(),
            m.getAuthorNo(),
            m.getGalleryNo(),
            m.getPostViews(),
            m.getCommentCount(),
            m.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
            m.getUnitTime()
        )
    ).toList();
  }
}
