package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.in.PostSystemUsecase;
import com.flab.ccinside.api.trendingpost.application.port.in.PostViewPersistCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;
import com.flab.ccinside.api.trendingpost.application.port.out.post.HandlePostViewPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.PersistPostViewPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostSystemService implements PostSystemUsecase {

  private final HandlePostViewPort handlePostViewPort;
  private final LoadPostPort loadPostPort;
  private final PersistPostViewPort persistPostViewPort;

  @Override
  public void updateViewCount(UpdateViewCountCommand command) {
    handlePostViewPort.addViewCount(command.postId());
  }

  @Transactional
  @Scheduled(fixedRate = 30000)
  public void persistViewCounts() {
    var allPosts = loadPostPort.loadAllPosts();
    log.info("Posts view count persisted. size: {}", allPosts.size());

    allPosts.forEach(
        post -> {
          var view = handlePostViewPort.getView(post.getId());
          var command = new PostViewPersistCommand(view);
          var persistedPost = post.persistViewCount(command);
          persistPostViewPort.modify(persistedPost);
        });
  }
}
