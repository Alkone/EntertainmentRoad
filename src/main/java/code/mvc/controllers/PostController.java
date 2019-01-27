package code.mvc.controllers;

import code.domain.userstable.entity.User;
import code.domain.userstable.usersrepository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/registration")
    public String addUser(User user){

        user.setBalance(5000);
        user.setEnabled(true);
        usersRepository.save(user);

        return "redirect:/main";
    }
}
