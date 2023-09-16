package shop;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoggedController {

    @GetMapping("/logged")
    private ModelAndView getLogged(@SessionAttribute("userAttribute") User user) {
        ModelAndView modelAndView = new ModelAndView("logged");
        List<Post> allPostsList = new ArrayList<>();


        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> usersList = (List<User>) session.createQuery("SELECT user from User user").getResultList();
        for (User myUser: usersList) {
            allPostsList.addAll(myUser.getPostList());
        }


        modelAndView.addObject("post",allPostsList);
        modelAndView.addObject("name",user.getName());

        return  modelAndView;

    }

}
