package nhan.api;

import nhan.obj.DataTest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/test")
public class TestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DataTest> getData() {
        List<DataTest> lstDt = new ArrayList<>();
        DataTest test = new DataTest(1, "Nguyen Ngoc Nhan", 23);
        DataTest test1 = new DataTest(2, "Nguyen Ngoc Nhan", 23);
        DataTest test2 = new DataTest(3, "Nguyen Ngoc Nhan", 23);
        DataTest test3 = new DataTest(4, "Nguyen Ngoc Nhan", 23);

        lstDt.add(test);
        lstDt.add(test1);
        lstDt.add(test2);
        lstDt.add(test3);

        return lstDt;
    }
}
