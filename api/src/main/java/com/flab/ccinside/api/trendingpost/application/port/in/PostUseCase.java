package com.flab.ccinside.api.trendingpost.application.port.in;

import com.flab.ccinside.api.trendingpost.adapter.out.persistence.post.PostId;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostUseCase {

  void create(CreatePostCommand command);

  PostData viewPostDetail(PostId postId);

  Page<PostData> viewPosts(Long galleryNo, Pageable pageable);
}
