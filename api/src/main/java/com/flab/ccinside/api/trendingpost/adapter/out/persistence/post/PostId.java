package com.flab.ccinside.api.trendingpost.adapter.out.persistence.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

public record PostId(@NotNull @JsonValue Long value) implements Serializable {

  @JsonCreator
  public static PostId from(@NotNull Long value) {
    return new PostId(value);
  }

  public static PostId from(@NotNull String value) {
    return new PostId(Long.valueOf(value));
  }
}
