package ru.mochalin.laba31.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mochalin.laba31.Model.Buyer;
import ru.mochalin.laba31.Repository.BuyerRepository;

@Controller
public class MainController {
    @Autowired
    private BuyerRepository buyerRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("buyers", buyerRepository.findAll());
        return "index";
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("buyer", buyerRepository.findById(id).get());
        return "update";
    }

    @PostMapping("/update")
    public String update(Buyer buyer) {
        buyerRepository.save(buyer);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createPage(Model model, Buyer buyer) {
        model.addAttribute("buyer", buyer);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("buyer") Buyer buyer) {
        buyerRepository.save(buyer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (buyerRepository.existsById(id)) {
            buyerRepository.deleteById(id);
        }
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable("id") Long id) {
        if (buyerRepository.existsById(id)) {
            Buyer buyer = buyerRepository.findById(id).get();
            model.addAttribute("buyer", buyer);
            return "details";
        }
        return "redirect:/";
    }
}
