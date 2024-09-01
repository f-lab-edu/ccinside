package com.flab.ccinside.api.trendingpost.adapter.in.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class TrendingPostControllerTest {

  @Autowired MockMvc mockMvc;

  @Autowired TrendingPostUseCase trendingPostUseCase;

  ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
  }

  @Test
  void publishNewTrendingPosts() throws Exception {
    // given

    // when
    ResultActions result = mockMvc.perform(post("/api/v1/trending/{galleryNo}/posts", 1));

    // then
    result.andExpect(status().isOk());
  }

  @Test
  void getTrendingPosts() throws Exception {
    // given

    // when
    ResultActions result = mockMvc.perform(get("/api/v1/trending/{galleryNo}/posts", 1));

    // then
    result
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()").isNotEmpty());
  }

  @Test
  void updateTrendingPosts() {}
}
