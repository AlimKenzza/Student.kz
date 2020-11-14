package Recources;

import dao.DB;
import model.Clubs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clubs")
public class ClubResource implements MainResource{
    private DB db = new DB();
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        Clubs club = db.getByClubId(id);
        if(club != null) {
            return Response.ok(club,MediaType.APPLICATION_JSON_TYPE).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    public List<Clubs> list() {
        return db.listAllClubs();
    }

    @DELETE
    @Path("{id}")
    @Override
    public void deleteById(@PathParam("id") int id) {
        db.deleteClubById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Clubs club) {
        db.addClub(club);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Clubs club) {
        db.updateClub(club);
    }
}
