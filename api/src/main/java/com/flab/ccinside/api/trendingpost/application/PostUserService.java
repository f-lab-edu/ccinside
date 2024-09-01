package com.flab.ccinside.api.trendingpost.application;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.in.CreatePostCommand;
import com.flab.ccinside.api.trendingpost.application.port.in.PostUserUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.application.port.out.post.AsyncPublishAddViewCountPort;
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
@RequiredArgsConstructor
public class PostUserService implements PostUserUseCase {

  private final CreatePostPort createPostPort;
  private final LoadPostPort loadPostPort;
  private final HandlePostViewPort handlePostViewPort;
  private final AsyncPublishAddViewCountPort publishAddViewCountPort;
  private final PostMapper mapper;

  @Override
  @Transactional
  public void create(CreatePostCommand command) {
    var post = Post.createWithoutId(command);
    createPostPort.createPost(post);
  }

  @Override
  public PostData viewPostDetail(PostId postId) {
    handlePostViewPort.addViewCount(postId);
    var viewCount = handlePostViewPort.getView(postId);
    var event = new ViewPostEvent(postId, viewCount);
    publishAddViewCountPort.add(event);
    return loadPostPort
        .loadPost(postId)
        .map(mapper::map)
        .orElseThrow(EntityNotFoundException::new)
        .toBuilder()
        .postViews(viewCount)
        .build();
  }

  @Override
  public Page<PostData> viewPosts(Long galleryNo, Pageable pageable) {
    return loadPostPort.loadPostsWithPage(galleryNo, pageable).map(mapper::map);
  }
}
