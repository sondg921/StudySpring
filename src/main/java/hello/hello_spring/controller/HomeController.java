package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // localhost8080 으로 접속시 home.html 보여줌
    public String home() {
        return "home";
    }
}