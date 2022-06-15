package example.controller;

import example.service.IChangeService;
import example.service.impl.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeController {

    @Autowired
    IChangeService iChangeService;

    @GetMapping("/")
    public String getIndex() {
        return "/index";
    }
    @PostMapping ("/change-money")
    public String getChangeMoney(@RequestParam int usd , Model model) {
        int vnd = iChangeService.returnResult(usd);
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "/index";
    }
}
