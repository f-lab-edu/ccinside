package com.flab.ccinside.api.trendingpost.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "post.post-not-found-exception")
public class PostNotFoundException extends RuntimeException {}
