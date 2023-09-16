package shop;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddPostController {

    @GetMapping("/add")
    private ModelAndView getAddPost() {
        return new ModelAndView("add");
    }


    @PostMapping("/add")
    private String doAddPost(@ModelAttribute("post") Post post, @SessionAttribute("userAttribute") User user ) {

        String title = post.getTitle();
        String imageUrl = post.getImageUrl();

        Post myPost = new Post();
        myPost.setTitle(title);
        myPost.setImageUrl(imageUrl);
        myPost.setUser(user);
        user.getPostList().add(myPost);


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(myPost);
        session.close();

        return "redirect:/logged";


    }

}
