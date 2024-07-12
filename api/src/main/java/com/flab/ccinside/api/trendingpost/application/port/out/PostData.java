package com.flab.ccinside.api.trendingpost.application.port.out;


import lombok.Builder;

@Builder
public record PostData(Long postNo, String postTitle, Integer commentCount, Long galleryNo, String galleryTitle,
                       String createdAt, String thumbnailUrl) {

  public static PostData of(Long postNo, String postTitle, Integer commentCount, Long galleryNo, String galleryTitle,
                            String createdAt, String thumbnailUrl) {

    return PostData.builder()
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
