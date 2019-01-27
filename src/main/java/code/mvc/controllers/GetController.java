package code.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetController {

    @GetMapping("/registration")
    public String reg(){
        return "/registration";
    }

    @GetMapping("/main")
    public String main(){
        return "/main";
    }

    @GetMapping("/")
    public String start(){
        return "redirect:/main";
    }
}
