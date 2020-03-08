package stupid.simple

import spock.lang.Specification
import java.util.concurrent.atomic.AtomicLong

class SomeControllerSpec extends Specification {

    def 'Mocking AtomicLong counter'() {
        given:
        'Test helloHandler without Spring context'
        def someName = 'someString'
        def counterMock = Mock(AtomicLong)
        // if counter field defined as private in class under test and injected with @Autowired
        // and constructor-based dependency injection unavailable for whatever reason, below approach can
        // be used to assign mocked instance to AtomicLong
        // this approach described as "not recommended" because class most likely should be redesigned
        // to do injection via constructor (easier to test, no need for workarounds as shown below)
        // https://stackoverflow.com/a/49312261/4101334
        // this will do private field mock injection
        // def someController = new SomeController(counter: counterMock)

        // after adding constructor that takes AtomicLong, below straightforward approach can be utilized
        def someController = new SomeController(counterMock)

        when:
        def response = someController.helloHandler(someName)
        def responseContent = response.getContent()
        def responseId = response.getId()

        then:
        responseContent == someName
        // responseId incremented with counter.incrementAndGet() and similar thing should be stubbed,
        // but there is no support for stubbing final methods:
        // http://spock-framework.3207229.n2.nabble.com/Mocking-classes-with-final-mehtods-td7573116.html
        // otherwise something like this can be done counterMock.incrementAndGet() >> 999
        // or
        // def counterMock = Mock(AtomicLong){
        //    incrementAndGet() >> 999
        // }
        responseId > 0
    }
}
