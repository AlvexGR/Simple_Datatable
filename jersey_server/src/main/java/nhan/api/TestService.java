package nhan.api;

import nhan.db.UserDao;
import nhan.dto.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
public class TestService {
    private UserDao userDao;
    public TestService() {
        userDao = new UserDao();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getData() {
        List<User> lstDt = userDao.getAll();
        return lstDt;
    }
}
