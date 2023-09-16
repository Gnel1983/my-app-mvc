package shop;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    private ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Post> allPostsList = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> usersList = (List<User>) session.createQuery("SELECT user from User user").getResultList();
        for (User user : usersList) {
            allPostsList.addAll(user.getPostList());
        }
         modelAndView.addObject("post",allPostsList);

        return  modelAndView;
    }
}
