package com.flab.ccinside.api.trendingpost.adapter.in.web;

import com.flab.ccinside.api.trendingpost.application.port.in.CreatePostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.PostUserUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.application.port.out.post.PostData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class PostUserController {

  private final PostUserUseCase postUseCase;

  @PostMapping("/{galleryNo}/posts")
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@PathVariable Long galleryNo, @RequestBody @Valid CreatePostCommand command) {
    var request = command.toBuilder().galleryNo(galleryNo).build();
    postUseCase.create(request);
  }

  @GetMapping("/{galleryNo}/posts")
  public Page<PostData> viewPosts(
      @PathVariable Long galleryNo, @PageableDefault Pageable pageable) {
    return postUseCase.viewPosts(galleryNo, pageable);
  }

  @GetMapping("/{galleryNo}/posts/{postId}")
  public PostData viewPostDetails(@PathVariable Long galleryNo, @PathVariable PostId postId) {
    return postUseCase.viewPostDetail(postId);
  }
}
