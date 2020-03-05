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

    @Autowired
    private AtomicLong counter;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/hello")
    public SimpleResponse helloHandler(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new SimpleResponse(counter.incrementAndGet(), name, simpleDateFormat.format(new Timestamp(System.currentTimeMillis())));
    }
}
