package nhan.db;

import nhan.obj.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("simple_datatable");

    public List<User> getAllBy() {
        EntityManager entityManager = factory.createEntityManager();
        String query = "Select u from User u";
        TypedQuery<User> result = entityManager.createQuery(query, User.class);
        try {
            return result.getResultList();
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
}
