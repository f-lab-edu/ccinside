package com.flab.ccinside.api.trendingpost.adapter.out.persistence.post;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<PostEntity, Long> {

  List<PostEntity> findByGalleryNo(Long galleryNo);

}
