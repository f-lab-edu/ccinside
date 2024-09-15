package com.flab.ccinside.api.trendingpost.adapter.in.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.in.PostSystemUsecase;
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;
import jakarta.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InMemoryMessageQueue {

  private final PostSystemUsecase postSystemUsecase;
  private final BlockingQueue<ViewPostEvent> queue;
  private final ExecutorService executorService = Executors.newSingleThreadExecutor();

  @PostConstruct
  public void init() {
    executorService.submit(
        () -> {
          try {
            while (true) {
              var event = queue.take();
              log.info("View post event consumed. postId: {}", event.postId());
              var command = new UpdateViewCountCommand(event.postId());
              postSystemUsecase.updateViewCount(command);
            }
          } catch (InterruptedException e) {
            log.error("consume error: {}", e.getMessage());
            throw new RuntimeException(e);
          }
        });
  }
}
