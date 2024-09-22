package com.flab.ccinside.api.trendingpost.adapter.out.post.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.out.post.AsyncPublishAddViewCountPort;
import java.util.Queue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InMemoryPostQueue implements AsyncPublishAddViewCountPort {

  private final Queue<ViewPostEvent> queue;

  @Override
  public void add(ViewPostEvent event) {
    log.info("publish add view count event. postId: {}", event.postId());
    queue.add(event);
  }
}
