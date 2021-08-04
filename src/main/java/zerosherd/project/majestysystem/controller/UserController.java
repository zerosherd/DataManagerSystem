package zerosherd.project.majestysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import zerosherd.project.majestysystem.dao.UserDao;


@Controller
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;

//    @RequestMapping("/users")
//    public String list(Model model) {
//        HashMap users = userDao.getAllUsers();
//        model.addAttribute("users", users.values());
//        return "users/tables";
//    }
}
