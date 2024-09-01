package com.flab.ccinside.api.trendingpost.domain;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.application.port.in.CreatePostCommand;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

  private final PostId id;
  private final String postTitle;
  private final Long authorNo;
  private final Long galleryNo;
  private final String createdAt;

  public static Post createWithoutId(CreatePostCommand command) {
    var createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    return new Post(null, command.title(), command.authorNo(), command.galleryNo(), createdAt);
  }
}
