package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {


    @GetMapping("log-test")
    public String logTest () {
        String name = "hobin";

        log.trace("trace log = {}", name);
        log.debug("debug = {}",name);
        log.info("info log = {}",name);
        log.warn("warn = {} ",name);
        log.error("error = {}", name );
        return "ok";
    }
}
