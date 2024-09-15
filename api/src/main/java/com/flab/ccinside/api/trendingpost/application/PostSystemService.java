package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.in.PostSystemUsecase;
import com.flab.ccinside.api.trendingpost.application.port.in.PostViewPersistCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;
import com.flab.ccinside.api.trendingpost.application.port.out.post.HandlePostViewPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.PersistPostViewPort;
import com.flab.ccinside.api.trendingpost.exception.PostNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
  @Override
  public void persistViewCountsInBatch(List<UpdateViewCountCommand> commands) {
    var posts =
        commands.stream()
            .map(
                command -> {
                  var post =
                      loadPostPort
                          .loadPost(command.postId())
                          .orElseThrow(PostNotFoundException::new);
                  var view = handlePostViewPort.getView(command.postId());
                  var postViewPersistCommand = new PostViewPersistCommand(view);
                  return post.persistViewCount(postViewPersistCommand);
                })
            .toList();

    persistPostViewPort.modifyInBatch(posts);
  }
}
