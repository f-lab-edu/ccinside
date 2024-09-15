package com.flab.ccinside.api.trendingpost.adapter.out.trendingpost.persistence;

import com.flab.ccinside.api.trendingpost.application.port.out.trendingpost.UnitTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
  @Column(name = "trending_post_no")
  private Long trendingPostNo;

  @Column(name = "post_no")
  private Long postNo;

  @Column private String title;

  @Column(name = "author_no")
  private Long authorNo;

  @Column(name = "gallery_no")
  private Long galleryNo;

  @Column(name = "post_views")
  private Integer postViews;

  @Enumerated(EnumType.STRING)
  @Column(name = "unit_time")
  private UnitTime unitTime;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
