package com.flab.ccinside.api.trendingpost.application.port.in;

import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Value;

//TODO: Validation 추가하기
@Value
public class PublishTrendingPostCommand {

  Long galleryNo;
  String currentTime;
  UnitTime unitTime;

  PublishTrendingPostCommand(Long galleryNo, UnitTime unitTime) {
    this.galleryNo = galleryNo;
    this.currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    this.unitTime = unitTime;
  }

  public static PublishTrendingPostCommand of(Long galleryNo, UnitTime unitTime) {
    return new PublishTrendingPostCommand(galleryNo, unitTime);
  }
}
