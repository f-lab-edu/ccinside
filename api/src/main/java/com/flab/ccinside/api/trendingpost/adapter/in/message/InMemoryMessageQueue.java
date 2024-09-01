package com.flab.ccinside.api.trendingpost.adapter.in.message;

import com.flab.ccinside.api.trendingpost.adapter.out.post.message.InMemoryPostQueue;
import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.in.PostSystemUsecase;
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("local")
@RequiredArgsConstructor
public class InMemoryMessageQueue {

  private final InMemoryPostQueue queue;
  private final PostSystemUsecase usecase;

  public void consume(ViewPostEvent event) {
    var command = new UpdateViewCountCommand(event.postId(), event.viewCount());
    usecase.updateViewCount(command);
  }
}
