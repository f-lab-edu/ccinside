package com.flab.ccinside.api.trendingpost.domain;

import com.flab.ccinside.api.trendingpost.application.port.in.CreatePostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.PostViewPersistCommand;
import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder(toBuilder = true)
public class Post {

  private final PostId id;
  private final String postTitle;
  private final Long authorNo;
  private final Long galleryNo;
  private final Integer viewCount;
  private final String createdAt;

  public static Post createWithoutId(CreatePostCommand command) {
    var createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    return new Post(null, command.title(), command.authorNo(), command.galleryNo(), 0, createdAt);
  }

  public Post persistViewCount(PostViewPersistCommand command) {
    return this.toBuilder().viewCount(command.viewCount()).build();
  }
}
