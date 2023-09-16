package shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class SignUpController {

    User user;

    @Autowired
    public SignUpController(User user) {
        this.user = user;
    }

    @GetMapping("/signup")
    private ModelAndView getSignup() {
        return new ModelAndView("signup");
    }

    @PostMapping("/signup")
    private String doSignup(@ModelAttribute("user") User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String userName = user.getUserName();
        String password = user.getPassword();
        String name = user.getName();


        user.setUserName(userName);
        user.setPassword(password);
        user.setName(name);
        session.save(user);
        session.close();

        return "redirect:/login";
    }
}
