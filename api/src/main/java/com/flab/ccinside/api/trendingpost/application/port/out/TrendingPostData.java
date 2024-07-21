package com.flab.ccinside.api.trendingpost.application.port.out;


import lombok.Builder;

@Builder
public record TrendingPostData(Long postNo, String postTitle, Integer commentCount, Long galleryNo, String galleryTitle,
                               String createdAt, String thumbnailUrl) {

  public static TrendingPostData of(Long postNo, String postTitle, Integer commentCount, Long galleryNo, String galleryTitle,
                                    String createdAt, String thumbnailUrl) {

    return TrendingPostData.builder()
                           .postNo(postNo)
                           .postTitle(postTitle)
                           .commentCount(commentCount)
                           .galleryNo(galleryNo)
                           .galleryTitle(galleryTitle)
                           .createdAt(createdAt)
                           .thumbnailUrl(thumbnailUrl)
                           .build();
  }
}
