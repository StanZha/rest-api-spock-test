package stupid.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SomeController {

    private AtomicLong counter;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public SomeController(AtomicLong counter){
        this.counter = counter;
    }

    @GetMapping("/hello")
    public SimpleResponse helloHandler(@RequestParam(value = "name", defaultValue = "UserName") String name) {
        return new SimpleResponse(counter.incrementAndGet(), name, simpleDateFormat.format(new Timestamp(System.currentTimeMillis())));
    }
}
