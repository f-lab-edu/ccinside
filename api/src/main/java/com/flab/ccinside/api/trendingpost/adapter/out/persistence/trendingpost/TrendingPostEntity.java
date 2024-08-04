package com.flab.ccinside.api.trendingpost.adapter.out.persistence.trendingpost;

import com.flab.ccinside.api.trendingpost.application.port.out.UnitTime;
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
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Entity
@Document
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrendingPostEntity {

  @Id
  @GeneratedValue(generator = "system-uuid")
  private String id;

  @Field(name = "post_id")
  private String postId;

  @Field
  private String title;

  @Field(name = "author_no")
  private Long authorNo;

  @Field(name = "gallery_no")
  private Long galleryNo;

  @Field(name = "post_views")
  private Integer postViews;

  @Enumerated(EnumType.STRING)
  @Field(name = "unit_time")
  private UnitTime unitTime;

  @Field(name = "created_at")
  private LocalDateTime createdAt;

}
