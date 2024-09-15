package com.flab.ccinside.api.trendingpost.adapter.out.post.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PostRepositorySupportImpl implements PostRepositorySupport {

  @PersistenceContext private final EntityManager em;

  @Override
  public void saveAllByBatch(List<PostEntity> posts) {
    posts.forEach(em::merge);
    em.flush();
    em.clear();
  }
}
