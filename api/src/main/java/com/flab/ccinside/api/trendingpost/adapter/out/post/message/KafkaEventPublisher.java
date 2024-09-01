package com.flab.ccinside.api.trendingpost.adapter.out.post.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.out.post.AsyncHandlePostPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("kafka")
@RequiredArgsConstructor
public class KafkaEventPublisher implements AsyncHandlePostPort {

  //TODO: Kafak로 이벤트 발행
  @Override
  public void add(ViewPostEvent event) {

  }
}
