package nhan.api;

import nhan.obj.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Test printTest() {
        return new Test("1", "Nguyen Ngoc Nhan", 23);
    }
}
