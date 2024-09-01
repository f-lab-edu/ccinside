package com.flab.ccinside.api.trendingpost.adapter.out.post.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;
import com.flab.ccinside.api.trendingpost.application.port.out.post.AsyncPublishAddViewCountPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.UpdateViewCountPersistencePort;
import java.util.concurrent.BlockingQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("local")
@RequiredArgsConstructor
public class InMemoryPostQueue
    implements AsyncPublishAddViewCountPort, UpdateViewCountPersistencePort {

  private final BlockingQueue<ViewPostEvent> queue;

  @Override
  public void add(ViewPostEvent event) {
    queue.add(event);
  }

  @Override
  public void update(UpdateViewCountCommand command) {
    // TODO
  }
}
