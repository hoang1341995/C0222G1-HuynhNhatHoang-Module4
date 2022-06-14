package example.controller;

import example.service.ValidateEmail;
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
    @PostMapping("/")
    public String postIndex(@RequestParam String email, Model model) {
        if (ValidateEmail.validateEmail(email)){
            model.addAttribute("success","Hi "+ email);
            model.addAttribute("hidden","hidden");
        }else {
            model.addAttribute("error","Email is invalid");
            model.addAttribute("email",email);
        }
        return "/index";
    }
}
