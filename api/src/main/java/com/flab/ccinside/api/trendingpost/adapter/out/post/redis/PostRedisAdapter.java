package com.flab.ccinside.api.trendingpost.adapter.out.post.redis;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.application.port.out.post.HandlePostViewPort;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostRedisAdapter implements HandlePostViewPort {

  private final StringRedisTemplate redisTemplate;
  private final BlockingQueue<Long> queue; //패턴써서 카프카로 잘 바뀌게
  private final ExecutorService executorService;

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
