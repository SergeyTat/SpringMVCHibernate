package SpringMVCHibernate.controller;

import SpringMVCHibernate.model.User;
import SpringMVCHibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String printCar(Model model) {
        model.addAttribute("user", userService.listUsers());
        return "user";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUser(id));
        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/remove")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";

    }
}
