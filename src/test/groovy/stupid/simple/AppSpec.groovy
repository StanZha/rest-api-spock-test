package stupid.simple;

import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = App)
class AppSpec extends Specification {

    @Autowired
    ApplicationContext applicationContext

    def "ApplicationContext is not null"() {
        expect:
        applicationContext != null
    }

    def "AtomicCounter is not null"() {
        expect:
        applicationContext.containsBeanDefinition('atomicLong')
    }

}