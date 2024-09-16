package com.flab.ccinside.api.trendingpost.adapter.in.message

import com.flab.ccinside.api.trendingpost.application.port.ViewPostEvent
import com.flab.ccinside.api.trendingpost.application.port.in.PostSystemUsecase
import com.flab.ccinside.api.trendingpost.application.port.in.UpdateViewCountCommand
import com.flab.ccinside.api.trendingpost.application.port.out.PostId
import com.flab.ccinside.api.trendingpost.config.InMemoryQueueConfig
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [InMemoryMessageQueue, InMemoryQueueConfig])
class InMemoryMessageQueueSpec extends Specification {

    @Autowired
    Queue<ViewPostEvent> queue

    @SpringBean
    ScheduledExecutorService executorService = Mock()

    @SpringBean
    PostSystemUsecase postSystemUsecase = Mock()

    def "인메모리 메시지큐 이벤트 소비 및 행위 검증- 정상"() {
        given:
        def event = new ViewPostEvent(PostId.from(1L))

        postSystemUsecase.updateViewCount(_) >> {}
        postSystemUsecase.persistViewCountsInBatch(_) >> {}
        1 * executorService.scheduleWithFixedDelay(_, _, _, _) >> { Runnable runnable, long l1, long l2, TimeUnit unit -> runnable.run()}

        queue.add(event)

        when:
        def inMemoryMessageQueue = new InMemoryMessageQueue(postSystemUsecase, queue, executorService)

        then:
        1 * postSystemUsecase.updateViewCount({it == new UpdateViewCountCommand(PostId.from(1L))})
        1 * postSystemUsecase.persistViewCountsInBatch({it == List.of(new UpdateViewCountCommand(PostId.from(1L)))})
    }
}
