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

    @PostMapping("/")
    public String postIndex(@RequestParam("condiment") String[] condiment, Model model) {
        String mess = "";
        if (condiment.length == 0) {
            mess = "you have not chosen !";
        } else {
            mess = "you chose: ";
            for (int i = 0; i < condiment.length; i++) {
                mess += condiment[i];
                model.addAttribute(condiment[i],"checked");
                if (i != (condiment.length - 1)) {
                    mess += ", ";
                }
            }
        }
        model.addAttribute("mess",mess);
        return "/index";
    }
}
