package pl.gp.moto_service.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gp.moto_service.entity.Oil;
import pl.gp.moto_service.repository.oil.OilService;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("panel")
public class OilController {

    private final OilService oilService;

    @GetMapping("/addoil")
    public String addOil(Model model){
        model.addAttribute("oil", new Oil());
        return "oil/addoil";
    }

    @PostMapping("/addoil")
    public String addOil(@ModelAttribute("oil") @Valid Oil oil, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "oil/addoil";
        }
        System.out.println(oil.toString());
        oilService.createOil(oil);
        return "oil/addoil";
    }
}
