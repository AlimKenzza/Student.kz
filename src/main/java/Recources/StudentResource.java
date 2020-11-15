package Recources;

import dao.StudentDao;
import model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
public class StudentResource implements MainResource<Student> {
    private final StudentDao dao = new StudentDao();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        Student student = dao.get(id);
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
        dao.delete(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Student> list() {
        return dao.fetch();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStudent(Student student) {
        dao.add(student);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Student student) {
        dao.edit(student);
    }

    @GET
    @Path("/year/{course}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByYear(@PathParam("course") int course) {
        List<Student> students = dao.getByYear(course);
        if (students != null) {
            return Response.ok(students, MediaType.APPLICATION_JSON_TYPE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/group/{group}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByGroup(@PathParam("group") int group) {
        List<Student> students = dao.getByGroup(group);
        if (students != null) {
            return Response.ok(students, MediaType.APPLICATION_JSON_TYPE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/major/{major}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByMajor(@PathParam("major") String major) {
        List<Student> students = dao.getByMajor(major);
        if (students != null) {
            return Response.ok(students, MediaType.APPLICATION_JSON_TYPE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}




