package com.flab.ccinside.api.trendingpost.adapter.out.post.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.out.post.AsyncHandlePostPort;
import java.util.concurrent.BlockingQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("memory")
@RequiredArgsConstructor
public class InMemoryPostQueue implements AsyncHandlePostPort {

  private final BlockingQueue<ViewPostEvent> queue;

  @Override
  public void add(ViewPostEvent event) {
    queue.add(event);
  }
}
