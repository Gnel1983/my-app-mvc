package shop;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserDao {


    

    User user = null;


    public User getUserFromDb(String userName, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();


        List<User> userList = (List<User>) session.createQuery("from User U where U.userName = :userName ").setParameter("userName", userName).getResultList();
        for (User requiredUser : userList) {
            if (requiredUser.getPassword().equals(password)) {
                return requiredUser;
            }
        }
        return null;
    }


}
