package com.flab.ccinside.api.trendingpost.adapter.out.web;

import com.flab.ccinside.api.trendingpost.application.port.out.LoadPostPort;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PostWebAdapter implements LoadPostPort {

  private final RestTemplate restTemplate;

  @Override
  public List<PostData> loadPosts(Long galleryNo) {
    //API 통신으로 PostData 로딩
    //반환 데이터 예시

    var response = new PostData(1L, "제목 - cc 인사이드 만들기", 1L, 1L, 121, 2,
        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    );
    return List.of(response);
  }

  @Override
  public List<PostData> loadPosts(Long galleryNo, UnitTime unitTime) {
    //특정 단위 시간 조건 추가
    //반환 데이터 예시

    var response = new PostData(1L, "제목 - cc 인사이드 만들기", 1L, 1L, 121, 2,
        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    return List.of(response);
  }
}
