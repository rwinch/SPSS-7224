package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import static org.springframework.http.HttpStatus.OK;

@SpringBootApplication
@RestController
public class Controller extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Controller.class, args);
    }

    @GetMapping("/test")
    public ResponseEntity<StreamingResponseBody> test() {
        return new ResponseEntity<>(outputStream -> outputStream.write("content".getBytes()), OK);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
    }
}
