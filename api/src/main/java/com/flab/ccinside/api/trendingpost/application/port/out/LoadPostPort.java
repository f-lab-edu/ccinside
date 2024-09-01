package com.flab.ccinside.api.trendingpost.application.port.out;

import com.flab.ccinside.api.trendingpost.adapter.out.persistence.post.PostId;
import com.flab.ccinside.api.trendingpost.domain.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoadPostPort {

  Optional<Post> loadPost(PostId postId);

  List<Post> loadPosts(Long galleryNo);

  Page<Post> loadPostsWithPage(Long galleryNo, Pageable pageable);
}
