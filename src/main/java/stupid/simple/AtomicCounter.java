package stupid.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicLong;

@Configuration
public class AtomicCounter {

    @Bean
    public AtomicLong atomicLong(){
        return new AtomicLong();
    }
}
