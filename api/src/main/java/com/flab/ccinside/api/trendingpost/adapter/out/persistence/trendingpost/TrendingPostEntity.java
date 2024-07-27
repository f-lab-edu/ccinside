package com.flab.ccinside.api.trendingpost.adapter.out.persistence.trendingpost;

import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trending_post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrendingPostEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long trendingPostNo;

  @Column
  private Long postNo;

  @Column
  private String title;

  @Column
  private Long authorNo;

  @Column
  private Long galleryNo;

  @Column
  private Integer postViews;

  @Column
  private Integer commentCount;

  @Column
  private UnitTime unitTime;

  @Column
  private LocalDateTime createdAt;

}
