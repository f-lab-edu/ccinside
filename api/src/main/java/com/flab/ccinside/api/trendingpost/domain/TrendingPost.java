package com.flab.ccinside.api.trendingpost.domain;

import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
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

  private Long postNo;
  private String postTitle;
  private Long authorNo;
  private Long galleryNo;
  private Integer postViews;
  private Integer commentCount;
  private String createdAt;
  private UnitTime unitTime;

  //TODO: 실시간 인기 게시글 비즈니스 로직 추가
  public static List<TrendingPost> publishTrendingPost(List<PostData> posts, UnitTime unitTime) {
    var postDatas = posts.stream()
                         .sorted(Comparator.comparing(PostData::postViews).reversed())
                         .limit(10L)
                         .collect(Collectors.toList());

    return TrendingPost.of(postDatas, unitTime);
  }

  public static List<TrendingPost> of(List<PostData> postDatas, UnitTime unitTime) {
    return postDatas.stream()
                    .map(m -> new TrendingPost(
                        m.postNo(),
                        m.postTitle(),
                        m.authorNo(),
                        m.galleryNo(),
                        m.postViews(),
                        m.commentCount(),
                        m.createdAt(),
                        unitTime
                    ))
                    .toList();
  }
}
