package com.flab.ccinside.api.trendingpost.config;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryQueueConfig {

  @Bean
  public BlockingQueue<ViewPostEvent> queue() {
    return new LinkedBlockingQueue<>();
  }
}
