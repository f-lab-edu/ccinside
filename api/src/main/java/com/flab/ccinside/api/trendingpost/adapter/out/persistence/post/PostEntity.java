package com.flab.ccinside.api.trendingpost.adapter.out.persistence.post;

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
@Table(name = "post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column private String title;

  @Column(name = "author_no")
  private Long authorNo;

  @Column(name = "gallery_no")
  private Long galleryNo;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}
