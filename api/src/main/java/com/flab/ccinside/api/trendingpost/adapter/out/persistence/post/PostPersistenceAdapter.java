package com.flab.ccinside.api.trendingpost.adapter.out.persistence.post;

import com.flab.ccinside.api.trendingpost.application.port.out.CreatePostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import com.flab.ccinside.api.trendingpost.domain.Post;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PostPersistenceAdapter implements LoadPostPort, CreatePostPort {

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

  @Override
  public void createPost(Post post) {
    var postEntity = mapper.map(post);
    postRepository.save(postEntity);
  }
}
