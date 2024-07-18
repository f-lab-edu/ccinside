package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import com.flab.ccinside.api.trendingpost.application.port.out.PublishTrendingPostPort;
import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TrendingPostService implements TrendingPostUseCase {

  private final PublishTrendingPostPort publishTrendingPostPort;

  @Override
  public void publishNewTrendingPosts() {
    var trendingPost = TrendingPost.publishTrendingPost();
    publishTrendingPostPort.publishTrendingPosts(trendingPost);

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
