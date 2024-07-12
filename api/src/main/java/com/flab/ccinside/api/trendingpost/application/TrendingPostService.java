package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
class TrendingPostService implements TrendingPostUseCase {

  @Override
  public void publishNewTrendingPosts() {

  }

  @Override
  public List<PostData> getTrendingPosts() {
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    PostData data = PostData.of(1L, "postTitle", 0, 1L, "galleryTitle", currentTime, "thumbnailUrl");
    return List.of(data);
  }

  @Override
  public void addOnePostIntoTrendingList(Long postNo) {

  }

  @Override
  public void deleteTrendingPost(Long postNo) {

  }
}
