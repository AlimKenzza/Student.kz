import dao.DB;
import model.Clubs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clubs")
public class ClubResource {
    private DB db = new DB();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Clubs> list() {
        return db.listAllClubs();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Clubs club = db.getByClubId(id);
        if(club != null) {
            return Response.ok(club,MediaType.APPLICATION_JSON_TYPE).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
