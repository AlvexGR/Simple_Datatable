package nhan.api;

import nhan.db.UserDao;
import nhan.dto.User;
import nhan.obj.UserListResponse;
import nhan.util.ServerUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserService {
    private UserDao userDao;
    public UserService() {
        userDao = new UserDao();
    }

    @GET
    @Path("/page/{page_num}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserListResponse getAll(@PathParam("page_num") Integer page) {
        try {
            if (page == null || page < 0) {
                page = 1;
            }
            int recordsPerPage = 10;
            UserListResponse userListResponse = userDao.getAll(page, recordsPerPage);
            if (page != 1) {
                userListResponse.setFirstPage(1);
            }
            int lastPage = userListResponse.getTotalPages();
            if (page != lastPage) {
                userListResponse.setLastPage(lastPage);
            }
            int nextPage = page + 1;
            if (nextPage <= lastPage) {
                userListResponse.setNextPage(nextPage);
            }

            int prevPage = page - 1;
            if (prevPage >= 1) {
                userListResponse.setPrevPage(prevPage);
            }
            return userListResponse;
        } catch (Exception ex) {
            return new UserListResponse();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") Integer id) {
        return userDao.getById(User.class, id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean register() {

        return true;
    }
}
