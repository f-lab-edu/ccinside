package com.flab.ccinside.api.trendingpost.adapter.out.persistence.post;

import com.flab.ccinside.api.trendingpost.domain.Post;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
class PostJpaMapper {

  Post map(PostEntity post) {
    return new Post(post.getPostNo(), post.getTitle(), post.getAuthorNo(), post.getGalleryNo(), post.getPostViews(),
        post.getCommentCount(), post.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), post.getUnitTime()
    );
  }

  //TODO: postNo 널포터질것같은데..?
  PostEntity map(Post post) {
    return new PostEntity(
        post.getPostNo(), post.getPostTitle(), post.getAuthorNo(), post.getGalleryNo(), post.getPostViews(),
        post.getCommentCount(), post.getUnitTime(),
        LocalDateTime.parse(post.getCreatedAt(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    );
  }

}
