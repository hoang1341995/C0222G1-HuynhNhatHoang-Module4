package com.example.music_plus.controller;

import com.example.music_plus.model.Music;
import com.example.music_plus.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "/")
    public String showIndex(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Music> list = iMusicService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("musicList", list);
        return "index";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String saveMusic(@Valid Music music, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        iMusicService.save(music);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editMusic(@PathVariable Integer id, Model model) {
        model.addAttribute("musicFindById", iMusicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateMusic(@Valid Music music, RedirectAttributes redirect) {
        iMusicService.update(music);
        redirect.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/view")
    public String viewMusic(@PathVariable Integer id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "view";
    }

    @GetMapping("{id}/delete")
    public String deleteMusic(@PathVariable Integer id, RedirectAttributes redirect) {
        iMusicService.remove(id);
        redirect.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page, String name, Model model) {
        Sort sort = Sort.by("id").ascending();
        Page<Music> list = iMusicService.searchByName(name, PageRequest.of(page, 2, sort));
        model.addAttribute("musicList", list);
        return "index";
    }
}
