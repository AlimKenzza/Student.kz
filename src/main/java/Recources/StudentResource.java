package Recources;

import dao.DB;
import model.Clubs;
import model.Students;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
public class StudentResource implements MainResource {
    private DB db = new DB();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        Students student = db.getById(id);
        if (student != null) {
            return Response.ok(student, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Override
    public void deleteById(@PathParam("id") int id) {
        db.deleteStudentById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Students> list() {
        return db.listAll();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStudent(Students student) {
        db.addStudent(student);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Students student) {
        db.updateStudent(student);
    }
}




