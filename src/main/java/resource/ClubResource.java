package resource;

import dao.ClubDao;
import model.Club;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Stack;

@Path("/clubs")
public class ClubResource implements MainResource<Club> {
    private final ClubDao dao = new ClubDao();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        Club club = dao.get(id);
        if (club != null) {
            return Response.ok(club, MediaType.APPLICATION_JSON_TYPE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Stack<Club> list() {
        return dao.fetch();
    }

    @DELETE
    @Path("{id}")
    @Override
    public void deleteById(@PathParam("id") int id) {
        dao.delete(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Club club) {
        dao.add(club);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Club club) {
        dao.edit(club);
    }
}
