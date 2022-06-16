package example.controller;

import example.service.ISandWichService;
import example.service.impl.SandWichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWichController {
    @Autowired
    private ISandWichService iSandWichService;

    @GetMapping("/")
    public String getIndex() {
        return "/index";
    }

    @PostMapping("/")
    public String postIndex(@RequestParam("condiment") String[] condiment, Model model) {
        String mess = iSandWichService.returnYourChose(condiment);
        for (int i = 0; i < condiment.length; i++) {
            model.addAttribute(condiment[i], "checked");
        }
        model.addAttribute("mess", mess);
        return "/index";
    }
}
