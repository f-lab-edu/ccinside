package com.flab.ccinside.api.trendingpost.application.port.out;


import lombok.Builder;

@Builder
public record TrendingPostData(String postId, String postTitle, Long galleryNo,
                               String createdAt) {

  public static TrendingPostData of(String postId, String postTitle, Long galleryNo,
                                    String createdAt) {

    return TrendingPostData.builder()
                           .postId(postId)
                           .postTitle(postTitle)
                           .galleryNo(galleryNo)
                           .createdAt(createdAt)
                           .build();
  }
}
