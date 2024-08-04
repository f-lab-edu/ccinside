package com.flab.ccinside.api.trendingpost.adapter.out.persistence.post;

import com.flab.ccinside.api.trendingpost.application.port.out.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import com.flab.ccinside.api.trendingpost.domain.Post;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PostPersistenceAdapter implements LoadPostPort {

  private final PostJpaRepository postRepository;
  private final PostJpaMapper mapper;

  @Override
  public List<Post> loadPosts(Long galleryNo) {
    var postEntities = postRepository.findByGalleryNo(galleryNo);

    return postEntities.stream().map(mapper::map).toList();
  }

  @Override
  public List<Post> loadPosts(Long galleryNo, UnitTime unitTime) {
    return null;
  }
}
