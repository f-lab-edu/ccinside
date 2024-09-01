package com.flab.ccinside.api.trendingpost.adapter.out.post.persistence;

import com.flab.ccinside.api.trendingpost.application.port.out.post.CreatePostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.domain.Post;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PostPersistenceAdapter implements LoadPostPort, CreatePostPort {

  private final PostJpaRepository postRepository;
  private final PostJpaMapper mapper;

  @Override
  public Optional<Post> loadPost(PostId postId) {
    return postRepository.findById(postId.value()).map(mapper::map);
  }

  @Override
  public List<Post> loadPosts(Long galleryNo) {
    var postEntities = postRepository.findByGalleryNo(galleryNo);

    return postEntities.stream().map(mapper::map).toList();
  }

  @Override
  public Page<Post> loadPostsWithPage(Long galleryNo, Pageable pageable) {
    return postRepository.findByGalleryNo(galleryNo, pageable).map(mapper::map);
  }

  @Override
  public void createPost(Post post) {
    var postEntity = mapper.map(post);
    postRepository.save(postEntity);
  }
}
