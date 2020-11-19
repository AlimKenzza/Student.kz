package resource;


import dao.Dao;
import dao.NewsDao;
import model.News;

import javax.enterprise.inject.New;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Path("/news")
public class NewsResource implements MainResource{
    NewsDao dao = new NewsDao();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response get(@PathParam("id") int id) {
        News info = dao.get(id);
        if (info != null) {
            return Response.ok(info, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<News> list() {
        return dao.fetch();
    }

    @DELETE
    @Path("{id}")
    @Override
    public void deleteById(@PathParam("id") int id) {
        dao.delete(id);
    }
}
