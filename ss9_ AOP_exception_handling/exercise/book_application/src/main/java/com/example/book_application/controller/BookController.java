package com.example.book_application.controller;


import com.example.book_application.model.Book;
import com.example.book_application.model.User;
import com.example.book_application.service.IBookService;
import com.example.book_application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IUserService iUserService;

    @ExceptionHandler()
    @GetMapping(value = "")
    public String showIndex( Model model) {
        User user = new User();
        int Random = (int)Math.floor((Math.random() * 89999) + 10000);
        model.addAttribute("bookList", iBookService.findAll());
        user.setCode(Random);
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/borrow")
    public String borrow(User user, RedirectAttributes redirect) {
        if (user.getBook().getAmount() == 0){
            redirect.addFlashAttribute("mess", "Sách đã hết, vui lòng mượn sách khác");
            redirect.addFlashAttribute("messModal", "$(`#messModal`).modal()");
        }else{
            iUserService.save(user);
            iBookService.update(user.getBook().getId());
            redirect.addFlashAttribute("mess", "Mượn thành công, Mã mượn sách của bạn là : "+ user.getCode());
            redirect.addFlashAttribute("messModal", "$(`#messModal`).modal()");
        }
        return "redirect:/";
    }

    @PostMapping("/giveBack")
    public String giveBack(@RequestParam(name = "bookId") Integer bookId, @RequestParam(name = "code") Integer code, RedirectAttributes redirect) {
    if (code == null){
        code = 1;
    }
        if (iBookService.giveBack(bookId,code)){
            redirect.addFlashAttribute("mess", "Trả sách thành công");
            redirect.addFlashAttribute("messModal", "$(`#messModal`).modal()");
        }else{
            redirect.addFlashAttribute("messErrorGiveBack", "Mã mượn sách sai hoặc không đúng sách mượn");
            redirect.addFlashAttribute("giveBackModal", "$(`#giveBackModal`).modal()");
        }
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }
}

