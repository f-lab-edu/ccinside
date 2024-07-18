package com.flab.ccinside.api.trendingpost.application.port.out;

public record PostMetaData(Long postNo, String postTitle, Long authorNo, Long galleryNo, Integer postViews, Integer viewsPerUnitTime, Integer commentCount) {

}
