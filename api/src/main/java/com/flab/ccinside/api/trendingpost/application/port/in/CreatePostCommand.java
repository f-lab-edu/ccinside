package com.flab.ccinside.api.trendingpost.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder(toBuilder = true)
public record CreatePostCommand(
    @NotNull String title, @NotNull Long authorNo, @NotNull Long galleryNo, Integer postView) {}
