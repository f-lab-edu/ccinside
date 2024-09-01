package com.flab.ccinside.api.trendingpost.domain;

import com.flab.ccinside.api.trendingpost.adapter.out.persistence.post.PostId;
import com.flab.ccinside.api.trendingpost.application.port.in.CreatePostCommand;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

  private PostId id;
  private String postTitle;
  private Long authorNo;
  private Long galleryNo;
  private String createdAt;

  public static Post createWithoutId(CreatePostCommand command) {
    var createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    return new Post(null, command.title(), command.authorNo(), command.galleryNo(), createdAt);
  }
}
