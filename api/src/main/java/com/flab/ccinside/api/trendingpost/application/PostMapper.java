package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import com.flab.ccinside.api.trendingpost.domain.Post;
import org.springframework.stereotype.Component;

@Component
class PostMapper {

  PostData map(Post post) {
    return new PostData(
        post.getId().value(),
        post.getPostTitle(),
        post.getAuthorNo(),
        post.getGalleryNo(),
        1,
        post.getCreatedAt());
  }
}
