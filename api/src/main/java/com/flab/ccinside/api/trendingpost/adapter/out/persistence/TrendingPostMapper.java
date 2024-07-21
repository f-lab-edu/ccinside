package com.flab.ccinside.api.trendingpost.adapter.out.persistence;

import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TrendingPostMapper {

  List<TrendingPostEntity> mapToEntity(List<TrendingPost> trendingPosts) {
    return trendingPosts.stream()
                                .map(m -> new TrendingPostEntity(
                                    m.getPostNo(),
                                    m.getPostTitle(),
                                    m.getGalleryNo(),
                                    m.getPostViews(),
                                    m.getCommentCount(),
                                    LocalDateTime.parse(m.getCreatedAt(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                                ))
                                .toList();
  }
}
