package com.flab.ccinside.api.trendingpost.adapter.out.post.redis;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.application.port.out.post.HandlePostViewPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostRedisAdapter implements HandlePostViewPort {

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
