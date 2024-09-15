package com.flab.ccinside.api.trendingpost.application.port.in;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.application.port.out.post.PostData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostUserUseCase {

  void create(CreatePostCommand command);

  PostData viewPostDetail(PostId postId);

  Page<PostData> viewPosts(Long galleryNo, Pageable pageable);
}
