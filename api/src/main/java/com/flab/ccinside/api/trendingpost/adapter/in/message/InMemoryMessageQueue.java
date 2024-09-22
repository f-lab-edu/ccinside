package com.flab.ccinside.api.trendingpost.adapter.in.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.in.PostSystemUsecase;
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InMemoryMessageQueue {

  private static final Long INITIAL_DELAY = 10L;
  private static final Long FIXED_DELAY = 100L;
  private static final int THRESHOLD = 100;

  public InMemoryMessageQueue(
      PostSystemUsecase postSystemUsecase,
      Queue<ViewPostEvent> queue,
      ScheduledExecutorService executorService) {

    executorService.scheduleWithFixedDelay(
        createEventConsumerRunnable(postSystemUsecase, queue),
        INITIAL_DELAY,
        FIXED_DELAY,
        TimeUnit.MILLISECONDS);
  }

  private Runnable createEventConsumerRunnable(
      PostSystemUsecase postSystemUsecase, Queue<ViewPostEvent> queue) {
    return () -> {
      try {
        List<UpdateViewCountCommand> commands = new ArrayList<>();
        ViewPostEvent event;
        int count = 0;
        while ((event = queue.poll()) != null && count < THRESHOLD) {
          log.info("View post event consumed. postId: {}", event.postId());
          var command = new UpdateViewCountCommand(event.postId());
          postSystemUsecase.updateViewCount(command);
          commands.add(command);
          count++;
        }
        postSystemUsecase.persistViewCountsInBatch(commands);
      } catch (Exception e) {
        log.error("error: {}", e.getMessage());
      }
    };
  }
}
