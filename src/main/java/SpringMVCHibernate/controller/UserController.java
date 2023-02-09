package SpringMVCHibernate.controller;

import SpringMVCHibernate.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {

    private final UserDao userDao;

    @Autowired

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/user")
    public String printCar(Model model) {
        model.addAttribute("user", userDao.listUsers());
        return "user";
    }
}
