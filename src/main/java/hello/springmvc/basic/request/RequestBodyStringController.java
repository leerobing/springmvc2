package hello.springmvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@Slf4j
public class RequestBodyStringController {

    @PostMapping("request-body-string-v1")
    public String requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("message = {}",message);
        return "OK";

    }

    @PostMapping("request-body-string-v2")
    public String requestBodyString(InputStream inputStream) throws IOException {

        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("message = {}",message);
        return "OK";

    }

    @PostMapping("request-body-string-v3")
    public ResponseEntity<String > requestBodyString(RequestEntity<String> httpEntity) throws IOException {

        String message = httpEntity.getBody();

        log.info("message = {}",message);
        return new ResponseEntity<String>("Success",HttpStatus.CREATED);

    }

    @PostMapping("request-body-string-v4")
    public ResponseEntity<String > requestBodyString(@RequestBody String message) throws IOException {
        log.info("message = {}",message);
        return new ResponseEntity<String>("Success",HttpStatus.CREATED);

    }

}
