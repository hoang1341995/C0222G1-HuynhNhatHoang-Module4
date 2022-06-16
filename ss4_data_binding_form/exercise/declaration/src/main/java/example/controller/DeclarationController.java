package example.controller;

import example.model.Declaration;
import example.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService iDeclarationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("yearOfBirthdayList",iDeclarationService.returnyearOfBirthdayListList());
        model.addAttribute("declaration", new Declaration());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showForm(@ModelAttribute Declaration declaration , Model model) {
        iDeclarationService.addNewDeclaration(declaration);
        model.addAttribute("message", "add new successful");
        model.addAttribute("openModalMessage", "$('#message').modal();");
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showList(Model model) {
        model.addAttribute("declarationList", iDeclarationService.returnDeclarationList());
        return "list";
    }
}
