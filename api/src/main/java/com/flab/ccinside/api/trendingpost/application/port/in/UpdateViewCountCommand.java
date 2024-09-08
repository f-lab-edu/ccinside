package com.flab.ccinside.api.trendingpost.application.port.in;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;

public record UpdateViewCountCommand(PostId postId) {}
