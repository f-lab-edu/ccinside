package com.flab.ccinside.api.trendingpost.adapter.in.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"alpha", "real"})
@RequiredArgsConstructor
public class KafkaMessageQueue {
  // TODO: 카프카 구현

  public void consume() {}
}
