package pl.gp.moto_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WeclomeController {

    @GetMapping

    public String welcome(){
        return "welcome";
    }
}
