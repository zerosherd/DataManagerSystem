package zerosherd.project.majestysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zerosherd.project.majestysystem.dao.UserDao;

import javax.servlet.http.HttpSession;

public class LoginController {
    public static int id;
    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public String login(
            @RequestParam("email_login_name") String username,
            @RequestParam("emailpassword") String password,
            Model model, HttpSession session) {
        Boolean isValid = userDao.isValidUser(username, password);
        if (isValid) {
            session.setAttribute("currentUser", username);
            return "index";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }
}
