package example.controller;

import example.service.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @PostMapping("/")
    public String PostIndex(@RequestParam String en, String vi, Model model) {
        Map<String,String> dicMap = Dictionary.returnDictionary(vi,en);
        if (dicMap.isEmpty()){
            model.addAttribute("mess","Không có trong từ điển");
        }else{
            model.addAttribute("map",dicMap);
        }
        return "/index";
    }
    @GetMapping("/")
    public String getIndex() {
        return "/index";
    }
}