package nhan.db;

import nhan.dto.User;
import nhan.obj.UserListResponse;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {
    public UserListResponse getAll(int page, int totalRecordsPerPage) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT u.*, (SELECT COUNT(*) FROM users) AS total_records ");
            sql.append(" FROM users u ");
            sql.append(" LIMIT :page, :totalRecordsPerPage ");

            Query query = entityManager.createNativeQuery(sql.toString());

            query.setParameter("page", (page - 1) * totalRecordsPerPage);
            query.setParameter("totalRecordsPerPage", totalRecordsPerPage);

            UserListResponse userListResponse = new UserListResponse();
            List<Object[]> result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                List<User> users = new ArrayList<>();
                result.forEach(obj -> {
                    User user = new User();
                    user.setId((Integer) obj[0]);
                    user.setFirstName(obj[1].toString());
                    user.setLastName(obj[2].toString());
                    user.setEmail(obj[3].toString());
                    user.setPhoneNumber(obj[4].toString());
                    user.setDateOfBirth(obj[5].toString());
                    user.setGender((Byte) obj[6] == 1);
                    user.setActive((Byte) obj[7] == 1);
                    users.add(user);
                });
                userListResponse.setUsers(users);
                userListResponse.setCurrentPage(page);
                int recordsAllPages = ((BigInteger) result.get(0)[8]).intValue();
                int remainPage = (recordsAllPages % totalRecordsPerPage) > 0 ? 1 : 0;
                int totalPages = (recordsAllPages / totalRecordsPerPage) + remainPage;
                userListResponse.setTotalPages(totalPages);
            }
            return userListResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
}
