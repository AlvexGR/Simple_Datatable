package nhan.db;

import nhan.obj.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao extends BaseDao {
    public List<User> getAll() {
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
