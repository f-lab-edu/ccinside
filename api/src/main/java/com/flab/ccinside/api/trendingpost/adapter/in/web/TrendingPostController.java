package com.flab.ccinside.api.trendingpost.adapter.in.web;

import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trending")
class TrendingPostController {

  private final TrendingPostUseCase trendingPostUseCase;

  @PostMapping("/posts")
  @ResponseStatus(HttpStatus.OK)
  void publishNewTrendingPosts() {
    trendingPostUseCase.publishNewTrendingPosts();
  }

  @GetMapping("/posts")
  @ResponseStatus(HttpStatus.OK)
  List<PostData> getTrendingPosts() {
    return trendingPostUseCase.getTrendingPosts();
  }

  @PatchMapping("/posts")
  @ResponseStatus(HttpStatus.OK)
  void updateTrendingPosts() {
    trendingPostUseCase.updateTrendingPosts();
  }
}
