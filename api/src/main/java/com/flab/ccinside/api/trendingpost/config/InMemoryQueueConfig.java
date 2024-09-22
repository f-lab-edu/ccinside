package com.flab.ccinside.api.trendingpost.config;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryQueueConfig {
  @Bean
  public Queue<ViewPostEvent> queue() {
    return new ConcurrentLinkedQueue<>();
  }

  @Bean
  public ScheduledExecutorService executorService() {
    return Executors.newScheduledThreadPool(1);
  }
}
