package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailboxController {
    @GetMapping("/")
    public String getIndex() {
        return "seting";
    }
}
