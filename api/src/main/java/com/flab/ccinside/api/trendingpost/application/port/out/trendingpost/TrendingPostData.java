package com.flab.ccinside.api.trendingpost.application.port.out.trendingpost;

import lombok.Builder;

@Builder
public record TrendingPostData(Long postNo, String postTitle, Long galleryNo, String createdAt) {

  public static TrendingPostData of(
      Long postNo, String postTitle, Long galleryNo, String createdAt) {

    return TrendingPostData.builder()
        .postNo(postNo)
        .postTitle(postTitle)
        .galleryNo(galleryNo)
        .createdAt(createdAt)
        .build();
  }
}
