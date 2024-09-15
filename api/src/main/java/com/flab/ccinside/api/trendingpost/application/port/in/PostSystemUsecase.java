package com.flab.ccinside.api.trendingpost.application.port.in;

import java.util.List;

public interface PostSystemUsecase {

  void updateViewCount(UpdateViewCountCommand command);

  void persistViewCountsInBatch(List<UpdateViewCountCommand> commands);
}
