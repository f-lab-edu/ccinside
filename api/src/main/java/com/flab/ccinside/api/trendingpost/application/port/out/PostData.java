package com.flab.ccinside.api.trendingpost.application.port.out;

public record PostData(Long postNo, String postTitle, Long authorNo, Long galleryNo, Integer postViews, String createdAt) {

}
