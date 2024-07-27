package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.in.PublishTrendingPostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.TrendingPostData;
import com.flab.ccinside.api.trendingpost.application.port.out.TrendingPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
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

  private final TrendingPostPort trendingPostPort;
  private final LoadPostPort loadPostPort;
  private final TrendingPostMapper mapper;

  @Override
  public void publishNewTrendingPosts(PublishTrendingPostCommand command) {
    var posts = loadPostPort.loadPosts(command.getGalleryNo());
    var trendingPosts = TrendingPost.publishTrendingPost(posts, command.getUnitTime());
    trendingPostPort.publishTrendingPosts(trendingPosts);
  }

  @Override
  public List<TrendingPostData> getTrendingPosts(Long galleryNo, UnitTime unitTime) {
    var trendingPosts = trendingPostPort.getTrendingPosts(galleryNo, unitTime);
    return mapper.map(trendingPosts);
  }

  @Override
  public void addOnePostIntoTrendingList(Long postNo) {

  }

  @Override
  public void deleteTrendingPost(Long postNo) {

  }
}
