package com.flab.ccinside.api.trendingpost.application.port.out;


public record PostData(Long postNo, String postTitle, Integer commentCount, Long galleryNo, String galleryTitle,
                       String createdAt, String thumbnailUrl) {

}
