package SpringMVCHibernate.controller;

import SpringMVCHibernate.dao.UserDao;
import SpringMVCHibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/")
    public String printCar(Model model) {
        model.addAttribute("user", userDao.listUsers());
        return "user";
    }
    @GetMapping(value = "/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "new";
    }

    @PostMapping(value = "create")
    public String createUser(@ModelAttribute ("user") User user){
        userDao.saveUser(user);
        return "redirect:/";
    }
    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user",userDao.findUser(id));
        return "edit";
    }
    @PatchMapping(value = "/edit")
    public String updateUser(@ModelAttribute ("user") User user){
        userDao.updateUser(user);
        return "redirect:/";
    }
    @GetMapping(value = "/{id}/remove")
    public String removeUser(@PathVariable("id") int id) {
        userDao.removeUser(id);
        return "redirect:/";

    }
}
