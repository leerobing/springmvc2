package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }
    @GetMapping("response-body-string-v4")
    public ResponseEntity<HelloData> responseBodyControllerV4(@RequestBody HelloData helloData) {
        HelloData data = new HelloData();
        data.setUsername(helloData.getUsername());
        data.setAge(helloData.getAge());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("response-body-string-v5")
    public HelloData responseBodyControllerV5(@RequestBody HelloData helloData) {
        HelloData data = new HelloData();
        data.setUsername(helloData.getUsername());
        data.setAge(helloData.getAge());
        return data;
    }
}
