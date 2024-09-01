package com.flab.ccinside.api.trendingpost.application.port;

import com.flab.ccinside.api.trendingpost.application.port.out.PostId;

public record ViewPostEvent(PostId postId, Integer viewCount) implements Event {

}
