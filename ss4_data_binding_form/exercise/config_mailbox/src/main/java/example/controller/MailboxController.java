package example.controller;

import example.model.Mailbox;
import example.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MailboxController {
    @Autowired
    private IMailboxService iMailboxService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("mailbox", new Mailbox());
        return "seting";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String subForm(@ModelAttribute("mailbox") Mailbox mailbox, Model model) {
        iMailboxService.addNewSettings(mailbox);
        model.addAttribute("message", "add new successful");
        model.addAttribute("openModalMessage", "$('#message').modal();");

        return "seting";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showList(Model model) {
        model.addAttribute("mailboxList", iMailboxService.returnMailboxList());
        return "list";
    }
}
