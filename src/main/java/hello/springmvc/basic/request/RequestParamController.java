package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1 (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}",username);
        log.info("age = {}",age);
        response.getWriter().write("OK");

    }

    @RequestMapping("/request-param-v2")
    public String requestParamV2 (@RequestParam("username") String username,
                                @RequestParam("age") int age)  {

        log.info("username = {}",username);
        log.info("age = {}",age);

        return "OK";
    }

    @RequestMapping("/request-param-required")
    public String requestParamRequired (@RequestParam(required = true) String username,
                                  @RequestParam(required = false) Integer age)  {

        log.info("username = {}",username);
        log.info("age = {}",age);

        return "OK";
    }

    @RequestMapping("/request-param-default")
    public String requestParamDefault (@RequestParam(required = true, defaultValue = "guest") String username,
                                        @RequestParam(required = false, defaultValue = "-1") int age)  {

        log.info("username = {}",username);
        log.info("age = {}",age);

        return "OK";
    }

    @RequestMapping("/request-param-map")
    public String requestParamMap (@RequestParam Map<String , Object> paramMap)  {

        log.info("username = {}",paramMap.get("username"));
        log.info("age = {}",paramMap.get("age"));

        return "OK";
    }
}
