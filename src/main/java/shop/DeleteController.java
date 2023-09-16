package shop;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class DeleteController {

    @GetMapping("/delete")
    private String delete(@RequestParam("id") int id, @SessionAttribute("userAttribute") User user) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Post post = session.get(Post.class, id);
        transaction = session.beginTransaction();


        session.delete(post);
        transaction.commit();
        session.close();
        return "redirect:/account";
    }
}
