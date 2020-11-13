

import dao.DB;
import model.Students;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
public class StudentResource {
    private DB db = new DB();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Students> list() {
        return db.listAll();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id ) {
        Students student = db.getById(id);
        if(student != null) {
            return Response.ok(student, MediaType.APPLICATION_JSON).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
