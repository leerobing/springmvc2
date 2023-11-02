package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class ResponseViewController {

    @GetMapping("/{data}")
    public String responseViewControllerV1(@PathVariable String data, Model model) {
        model.addAttribute("data",data);
        return "/response/hello";
    }
}
