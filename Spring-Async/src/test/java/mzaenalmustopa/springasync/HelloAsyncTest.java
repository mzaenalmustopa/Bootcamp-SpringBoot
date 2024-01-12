package mzaenalmustopa.springasync;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest
class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void helloAsync() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            helloAsync.hello();
        }

        log.info("after call hello()");
        Thread.sleep(Duration.ofSeconds(10));
    }

    @Test
    void helloName() throws ExecutionException, InterruptedException {
        Future<String> future = helloAsync.hello("Topa");
        log.info("after call hello(Topa)");
        String response = future.get();
        log.info(response);
    }
}