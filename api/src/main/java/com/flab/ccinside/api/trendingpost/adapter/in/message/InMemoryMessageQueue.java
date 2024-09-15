package com.flab.ccinside.api.trendingpost.adapter.in.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.in.PostSystemUsecase;
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InMemoryMessageQueue {

  public InMemoryMessageQueue(PostSystemUsecase postSystemUsecase, Queue<ViewPostEvent> queue) {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    executorService.scheduleWithFixedDelay(() -> {
      try {
        ViewPostEvent event;
        while ((event = queue.poll()) != null) {
          log.info("View post event consumed. postId: {}", event.postId());
          var command = new UpdateViewCountCommand(event.postId());
          postSystemUsecase.updateViewCount(command);
        }
      } catch (Exception e) {
        log.error("error: {}", e.getMessage());
      }
}, 10, 100, TimeUnit.MILLISECONDS);
  }
}
