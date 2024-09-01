package com.flab.ccinside.api.trendingpost.adapter.out.post.persistence;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<PostEntity, Long> {

  List<PostEntity> findByGalleryNo(Long galleryNo);

  Page<PostEntity> findByGalleryNo(Long galleryNo, Pageable pageable);
}
