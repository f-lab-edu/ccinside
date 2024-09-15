package com.flab.ccinside.api.trendingpost.application.port.out.post;

import lombok.Builder;

@Builder(toBuilder = true)
public record PostData(
    Long postNo,
    String postTitle,
    Long authorNo,
    Long galleryNo,
    Integer postViews,
    String createdAt) {}
