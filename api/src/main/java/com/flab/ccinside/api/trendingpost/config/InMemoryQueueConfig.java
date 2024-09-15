package com.flab.ccinside.api.trendingpost.config;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryQueueConfig {
  @Bean
  public Queue<ViewPostEvent> queue() {
    return new ConcurrentLinkedQueue<>();
  }
}
