package nhan.api;

import nhan.db.UserDao;
import nhan.obj.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserService {
    private UserDao userDao;
    public UserService() {
        userDao = new UserDao();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getById() {
        return userDao.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") Integer id) {
        return userDao.getById(User.class, id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean register() {

        return true;
    }
}
