package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.out.trendingpost.TrendingPostData;
import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class TrendingPostMapper {

  public List<TrendingPostData> map(List<TrendingPost> trendingPost) {

    return trendingPost.stream()
        .map(
            m ->
                new TrendingPostData(
                    m.getTrendingPostNo(), m.getPostTitle(), m.getGalleryNo(), m.getCreatedAt()))
        .toList();
  }
}
