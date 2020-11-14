package Recources;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

public interface MainResource {
    Response get(int id);
    List list();
    void deleteById(int id);
}
