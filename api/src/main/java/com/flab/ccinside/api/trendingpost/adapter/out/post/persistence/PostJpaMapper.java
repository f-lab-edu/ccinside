package com.flab.ccinside.api.trendingpost.adapter.out.post.persistence;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;
import com.flab.ccinside.api.trendingpost.domain.Post;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
class PostJpaMapper {

  Post map(PostEntity post) {
    return new Post(
        PostId.from(post.getId()),
        post.getTitle(),
        post.getAuthorNo(),
        post.getGalleryNo(),
        post.getViewCount(),
        post.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  PostEntity map(Post post) {
    return new PostEntity(
        Optional.ofNullable(post.getId()).map(PostId::value).orElse(null),
        post.getPostTitle(),
        post.getAuthorNo(),
        post.getGalleryNo(),
        post.getViewCount(),
        LocalDateTime.parse(post.getCreatedAt(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }
}
