package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

@SpringBootApplication
@RestController
public class Controller {

    public static void main(String[] args) {
        SpringApplication.run(Controller.class, args);
    }

    @GetMapping("/test")
    public Callable<Void> nosecurity(HttpServletResponse response) {
        return () -> {
            for (int i = 0; i < 10; i++) {
                response.setHeader("bar " + i, "foo");
            }
            return null;
        };
    }
}
