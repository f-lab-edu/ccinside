package com.flab.ccinside.api.trendingpost.application.port.out.post;

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent;

public interface AsyncPublishAddViewCountPort {

  void add(ViewPostEvent event);
}
