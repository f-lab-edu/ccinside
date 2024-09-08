package application

import com.flab.ccinside.api.trendingpost.application.PostMapper
import com.flab.ccinside.api.trendingpost.application.PostUserService
import com.flab.ccinside.api.trendingpost.application.port.out.PostId
import com.flab.ccinside.api.trendingpost.application.port.out.post.AsyncPublishAddViewCountPort
import com.flab.ccinside.api.trendingpost.application.port.out.post.CreatePostPort
import com.flab.ccinside.api.trendingpost.application.port.out.post.HandlePostViewPort
import com.flab.ccinside.api.trendingpost.application.port.out.post.LoadPostPort
import fixture.PostFixture
import fixture.ViewPostEventFixture
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [PostUserService, PostMapper])
class PostUserServiceSpec extends Specification {
    @Autowired
    PostUserService postUserService
    @Autowired
    PostMapper mapper

    @SpringBean
    CreatePostPort createPostPort = Mock()
    @SpringBean
    LoadPostPort loadPostPort = Mock()
    @SpringBean
    HandlePostViewPort handlePostViewPort = Mock()
    @SpringBean
    AsyncPublishAddViewCountPort publishAddViewCountPort = Mock()



    def "게시글 조회시, 조회 이벤트 발행 - 정상"() {
        given:
        var event = ViewPostEventFixture.VIEW_POSE_EVENT
        handlePostViewPort.getView(_) >> 1
        loadPostPort.loadPost(_) >> Optional.of(PostFixture.POST)

        when:
        def got = postUserService.viewPostDetail(PostId.from(1L));

        then:
        1 * publishAddViewCountPort.add({it == event})
        got.postTitle() == "test post title"
        got.authorNo() == 1L
        got.postNo() == 1L
    }
}
