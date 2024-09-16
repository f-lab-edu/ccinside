package fixture

import com.flab.ccinside.api.trendingpost.application.port.out.PostId
import com.flab.ccinside.api.trendingpost.domain.Post
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PostFixture {

    static final Post POST = new Post(PostId.from(1L), "test post title", 1L, 1L, 0, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
}
