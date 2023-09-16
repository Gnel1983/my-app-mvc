package shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names = "userAttribute")
public class LoginController {

    UserDao userDao;


    @Autowired
    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    private ModelAndView getLogin() {
        return new ModelAndView("login");
    }


    @PostMapping("/login")
    private String doLogin(@ModelAttribute("user") User user, Model model) {

        String userName = user.getUserName();
        String password = user.getPassword();


        User userFromDb = userDao.getUserFromDb(userName, password);

        if (userFromDb != null) {
            model.addAttribute("userAttribute", userFromDb);
            return "redirect:/logged";
        }

        return "redirect:/login?error";
    }

}
