package com.flab.ccinside.api.trendingpost.adapter.in.web;

import com.flab.ccinside.api.trendingpost.application.port.in.PublishTrendingPostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.TrendingPostData;
import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trending")
class TrendingPostController {

  private final TrendingPostUseCase trendingPostUseCase;

  @PostMapping("/{galleryNo}/posts")
  @ResponseStatus(HttpStatus.OK)
  void publishNewTrendingPosts(
      @PathVariable Long galleryNo, @RequestParam(defaultValue = "ONE_HOUR") UnitTime unitTime) {
    var command = PublishTrendingPostCommand.of(galleryNo, unitTime);
    trendingPostUseCase.publishNewTrendingPosts(command);
  }

  @GetMapping("/{galleryNo}/posts")
  @ResponseStatus(HttpStatus.OK)
  List<TrendingPostData> getTrendingPosts(
      @PathVariable Long galleryNo, @RequestParam(defaultValue = "ONE_HOUR") UnitTime unitTime) {
    return trendingPostUseCase.getTrendingPosts(galleryNo, unitTime);
  }

  @PutMapping("/posts/{postNo}")
  @ResponseStatus(HttpStatus.OK)
  void addOnePostIntoTrendingList(@PathVariable Long postNo) {
    trendingPostUseCase.addOnePostIntoTrendingList(postNo);
  }

  @DeleteMapping("/posts/{postNo}")
  @ResponseStatus(HttpStatus.OK)
  void deleteTrendingPost(@PathVariable Long postNo) {
    trendingPostUseCase.deleteTrendingPost(postNo);
  }
}
