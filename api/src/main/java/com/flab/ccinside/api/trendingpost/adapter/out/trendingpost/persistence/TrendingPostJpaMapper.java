package com.flab.ccinside.api.trendingpost.adapter.out.trendingpost.persistence;

import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class TrendingPostJpaMapper {

  List<TrendingPostEntity> mapToEntity(List<TrendingPost> trendingPosts) {
    return trendingPosts.stream()
        .map(
            m ->
                new TrendingPostEntity(
                    m.getTrendingPostNo(),
                    m.getTrendingPostNo(),
                    m.getPostTitle(),
                    m.getAuthorNo(),
                    m.getGalleryNo(),
                    1, // view 수정..
                    m.getUnitTime(),
                    LocalDateTime.parse(m.getCreatedAt(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
        .toList();
  }

  List<TrendingPost> mapToDomain(List<TrendingPostEntity> trendingPosts) {
    return trendingPosts.stream()
        .map(
            m ->
                new TrendingPost(
                    m.getTrendingPostNo(),
                    m.getPostNo(),
                    m.getTitle(),
                    m.getAuthorNo(),
                    m.getGalleryNo(),
                    m.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    m.getUnitTime()))
        .toList();
  }
}
