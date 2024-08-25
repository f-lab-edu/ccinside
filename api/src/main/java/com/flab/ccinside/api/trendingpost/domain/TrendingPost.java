package com.flab.ccinside.api.trendingpost.domain;

import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrendingPost {

  private Long trendingPostNo;
  private Long postNo;
  private String postTitle;
  private Long authorNo;
  private Long galleryNo;
  private String createdAt;
  private UnitTime unitTime;

  //TODO: 조회수 레디스로 분리..?
  public static List<TrendingPost> publishTrendingPost(List<Post> posts, UnitTime unitTime) {
    var postDatas = posts.stream()
                         .limit(10L)
                         .collect(Collectors.toList());

    return TrendingPost.of(postDatas, unitTime);
  }

  public static List<TrendingPost> of(List<Post> posts, UnitTime unitTime) {
    return posts.stream()
                    .map(m -> new TrendingPost(
                        null,
                        m.getId().value(),
                        m.getPostTitle(),
                        m.getAuthorNo(),
                        m.getGalleryNo(),
                        m.getCreatedAt(),
                        unitTime
                    ))
                    .toList();
  }
}
