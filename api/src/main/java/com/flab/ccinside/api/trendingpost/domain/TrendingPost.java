package com.flab.ccinside.api.trendingpost.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrendingPost {

  //각 시판 게시물들의 정보를 가져온다. (메타데이터?)
  //각 갤러리별로 실시간 인기 게시글 TOP 10 선정
  // DB에 저장
  // 1. 전체 갤러리에서 top 10 정렬해서 저장
  // 2. 갤러리별 인기 게시글을 각 갤러리별로 저장
  public static TrendingPost publishTrendingPost() {
    return null;
  }
}
