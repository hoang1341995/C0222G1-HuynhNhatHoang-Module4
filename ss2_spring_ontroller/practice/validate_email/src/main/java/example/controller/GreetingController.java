package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String getIndex() {
        return "/index";
    }
    @PostMapping("/")
    public String postIndex() {
        
        return "/index";
    }
}
