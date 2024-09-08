package fixture

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent
import com.flab.ccinside.api.trendingpost.application.port.out.PostId

class ViewPostEventFixture {

    static final VIEW_POSE_EVENT = new ViewPostEvent(PostId.from(1L))
}
