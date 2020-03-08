package stupid.simple

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = App)
class AppSpec extends Specification {

    @Autowired
    ApplicationContext applicationContext

    def setup() {
        println('will be executed before every test method')
//        line below will print test method name in output
        println(specificationContext.currentIteration.name)
    }

    def cleanup() {
        println('will be executed after every test method')
    }

    def setupSpec() {
        println('will be executed before the first feature method')
    }

    def cleanupSpec() {
        println('will be executed after the first feature method')
    }

    def 'ApplicationContext is not null'() {
        expect:
        applicationContext != null
    }

    def 'AtomicCounter is not null'() {
        expect:
        applicationContext.containsBeanDefinition('atomicLong')
    }

}