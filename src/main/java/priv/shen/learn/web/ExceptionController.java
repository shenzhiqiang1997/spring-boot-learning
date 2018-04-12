package priv.shen.learn.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/json")
    public String exception() throws Exception {
        throw new Exception("json error");
    }
}
