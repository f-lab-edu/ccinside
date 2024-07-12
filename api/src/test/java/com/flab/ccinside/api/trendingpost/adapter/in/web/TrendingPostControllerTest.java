package com.flab.ccinside.api.trendingpost.adapter.in.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.flab.ccinside.api.trendingpost.application.port.in.TrendingPostUseCase;
import com.flab.ccinside.api.trendingpost.application.port.out.PostData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
class TrendingPostControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  TrendingPostUseCase trendingPostUseCase;

  ObjectMapper mapper;
  List<PostData> expectedPosts;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    expectedPosts = List.of(
        new PostData(1L, "title1", 10, 1L, "gallery1", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), "url1"),
        new PostData(2L, "title2", 20, 2L, "gallery2", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), "url2")
    );
  }

  @Test
  void publishNewTrendingPosts() {

  }

  @Test
  void getTrendingPosts() throws Exception {
    //given
    given(trendingPostUseCase.getTrendingPosts()).willReturn(expectedPosts);

    //when
    ResultActions result = mockMvc.perform(get("/api/v1/trending/posts"));

    //then
    result.andExpect(status().isOk())
          .andExpect(content().contentType(MediaType.APPLICATION_JSON))
          .andExpect(content().json(mapper.writeValueAsString(expectedPosts)));
  }

  @Test
  void updateTrendingPosts() {
  }
}