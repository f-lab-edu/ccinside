package com.flab.ccinside.api.trendingpost.application.port.out.post;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;
import com.flab.ccinside.api.trendingpost.application.port.out.PostId;

public interface AsyncHandlePostPort {

  void add(ViewPostEvent event);

}
