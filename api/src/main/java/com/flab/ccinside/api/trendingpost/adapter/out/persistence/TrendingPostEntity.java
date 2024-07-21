package com.flab.ccinside.api.trendingpost.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
public class TrendingPostEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String title;

  @Column
  private Long galleryNo;

  @Column
  private Integer postViews;

  @Column
  private Integer commentCount;

  @Column
  private LocalDateTime createdAt;

}
