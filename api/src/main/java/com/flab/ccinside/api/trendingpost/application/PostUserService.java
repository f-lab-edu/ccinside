package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.application.port.in.CreatePostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.PostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.post.CreatePostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.HandlePostViewPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.post.PostData;
import com.flab.ccinside.api.trendingpost.domain.Post;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostUserService implements PostUseCase {

  private final CreatePostPort createPostPort;
  private final LoadPostPort loadPostPort;
  private final HandlePostViewPort handlePostViewPort;
  private final PostMapper mapper;

  @Override
  public void create(CreatePostCommand command) {
    var post = Post.createWithoutId(command);
    createPostPort.createPost(post);
  }

  @Override
  public PostData viewPostDetail(PostId postId) {
    handlePostViewPort.addViewCount(postId);
    var viewCount = handlePostViewPort.getView(postId);
    return loadPostPort.loadPost(postId).map(mapper::map).orElseThrow(EntityNotFoundException::new).toBuilder()
                       .postViews(viewCount).build();
  }

  @Override
  public Page<PostData> viewPosts(Long galleryNo, Pageable pageable) {
    return loadPostPort.loadPostsWithPage(galleryNo, pageable).map(mapper::map);
  }

  @Override
  public void addPostViewCount(PostId postId) {
    Post post = loadPostPort.loadPost(postId).orElseThrow(EntityNotFoundException::new);

    handlePostViewPort.addViewCount(post.getId());
  }
}
