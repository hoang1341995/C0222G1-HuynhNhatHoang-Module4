package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String getIndex() {
        return "/index";
    }
    @PostMapping ("/change-money")
    public String getChangeMoney(@RequestParam int usd , Model model) {
        int vnd = usd * 23000;
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "/index";
    }
}
