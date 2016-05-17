import org.hibernate.Session;
import pojos.Meal;
import pojos.User;
import utils.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by KIRILL on 17.05.2016.
 */
public class ProjectApp {

    public static void main(String[] args) {
        System.out.println("Hibernate many to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Meal meal = new Meal();
        meal.setMealName("meal_1");
        meal.setMealPrice(100);
        meal.setMealTime(100);
        meal.setMealConsist("test_consist");


        User user1 = new User();
        user1.setFirstName("kirill");
        user1.setSecongName("deg");
        user1.setLogin("test");
        user1.setPassword("test");
        user1.setStatus("test_status");


        User user2 = new User();
        user2.setFirstName("kirill2");
        user2.setSecongName("deg2");
        user2.setLogin("test2");
        user2.setPassword("test2");
        user2.setStatus("test_status2");

        Set<User> users = new HashSet<User>();
        users.add(user1);
        users.add(user2);

        meal.setUsers(users);

        session.save(meal);
        session.getTransaction().commit();

        System.out.println("Done");
    }
}
