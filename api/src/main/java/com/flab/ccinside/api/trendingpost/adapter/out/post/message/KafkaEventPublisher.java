package com.flab.ccinside.api.trendingpost.adapter.out.post.message;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.out.post.AsyncPublishAddViewCountPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"alpha", "real"})
@RequiredArgsConstructor
public class KafkaEventPublisher implements AsyncPublishAddViewCountPort {

  // TODO: Kafak로 이벤트 발행
  @Override
  public void add(ViewPostEvent event) {}
}
