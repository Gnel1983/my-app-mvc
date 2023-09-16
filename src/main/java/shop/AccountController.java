package shop;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccountController {


    @GetMapping("/account")
    private ModelAndView getAccount(@SessionAttribute("userAttribute") User user) {

        int id = user.getUserId();

        Session session = HibernateUtil.getSessionFactory().openSession();
        User myUser = session.get(User.class, id);
        List<Post> postsList = myUser.getPostList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("post", postsList);


        return modelAndView;
    }
}
