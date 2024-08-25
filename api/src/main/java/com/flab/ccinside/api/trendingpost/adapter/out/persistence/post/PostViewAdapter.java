package com.flab.ccinside.api.trendingpost.adapter.out.persistence.post;

import com.flab.ccinside.api.trendingpost.application.port.out.HandlePostViewPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostViewAdapter implements HandlePostViewPort {

  private final StringRedisTemplate redisTemplate;

  @Override
  public void addViewCount(PostId postId) {
    var key = "post:view:" + postId.value();
    redisTemplate.opsForValue().increment(key);
  }

  @Override
  public Integer getView(PostId postId) {
    var key = "post:view:" + postId.value();
    var value = redisTemplate.opsForValue().get(key);

    return value == null ? 0 : Integer.parseInt(value);
  }
}
