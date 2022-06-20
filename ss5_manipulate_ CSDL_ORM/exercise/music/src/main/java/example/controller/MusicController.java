package example.controller;

import example.model.Music;
import example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "/")
    public String showIndex(Model model) {
        model.addAttribute("musicList",iMusicService.findAll());
        return "index";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(Music music, RedirectAttributes redirect) {
        iMusicService.save(music);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editMusic(@PathVariable Integer id, Model model) {
        model.addAttribute("MusicFindById", iMusicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(Music music, RedirectAttributes redirect) {
        iMusicService.update(music);
        redirect.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/view")
    public String viewProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "view";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        iMusicService.remove(iMusicService.findById(id));
        redirect.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(String name, Model model) {
        model.addAttribute("musicList", iMusicService.searchByName(name));
        return "index";
    }
}
