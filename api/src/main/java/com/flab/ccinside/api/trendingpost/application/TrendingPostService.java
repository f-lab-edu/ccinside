package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.in.PublishTrendingPostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import com.flab.ccinside.api.trendingpost.application.port.out.TrendingPostData;
import com.flab.ccinside.api.trendingpost.application.port.out.PublishTrendingPostPort;
import com.flab.ccinside.api.trendingpost.domain.TrendingPost;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class TrendingPostService implements TrendingPostUseCase {

  private final PublishTrendingPostPort publishTrendingPostPort;
  private final LoadPostPort loadPostPort;

  @Override
  public void publishNewTrendingPosts(PublishTrendingPostCommand command) {
    var posts = loadPostPort.loadPosts(command.getGalleryNo());
    var trendingPosts = TrendingPost.publishTrendingPost(posts, command.getUnitTime());
    publishTrendingPostPort.publishTrendingPosts(trendingPosts);

  }

  @Override
  public List<TrendingPostData> getTrendingPosts() {
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    TrendingPostData data = TrendingPostData.of(1L, "postTitle", 0, 1L, "galleryTitle", currentTime, "thumbnailUrl");
    return List.of(data);
  }

  @Override
  public void addOnePostIntoTrendingList(Long postNo) {

  }

  @Override
  public void deleteTrendingPost(Long postNo) {

  }
}
