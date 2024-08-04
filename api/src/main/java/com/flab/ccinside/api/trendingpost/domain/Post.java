package com.flab.ccinside.api.trendingpost.domain;

import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

  //TODO: Long 대신 PostNo로 PK 변경?
  private String postNo;
  private String postTitle;
  private Long authorNo;
  private Long galleryNo;
  private Integer postViews;
  private String createdAt;
  private UnitTime unitTime;

}
