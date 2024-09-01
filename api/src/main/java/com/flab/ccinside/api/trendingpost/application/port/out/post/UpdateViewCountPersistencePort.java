package com.flab.ccinside.api.trendingpost.application.port.out.post;

import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand;

public interface UpdateViewCountPersistencePort {

  void update(UpdateViewCountCommand command);
}
