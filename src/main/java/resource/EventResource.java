package resource;

import dao.EventDao;
import model.Event;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Queue;

@Path("/events")
public class EventResource implements MainResource<Event> {
    private final EventDao dao = new EventDao();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        Event event = dao.get(id);
        if (event != null) {
            return Response.ok(event, MediaType.APPLICATION_JSON_TYPE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Event> list() {
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
    public void add(Event event) {
        dao.add(event);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Event event) {
        dao.edit(event);
    }
}
