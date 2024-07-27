package com.flab.ccinside.api.trendingpost.adapter.out.persistence.trendingpost;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendingPostJpaRepository extends JpaRepository<TrendingPostEntity, Long> {

  List<TrendingPostEntity> findByGalleryNo(Long galleryNo);
}
