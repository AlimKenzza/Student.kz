package Recources;

import javax.ws.rs.core.Response;
import java.util.Collection;

public interface MainResource<T> {
    Response get(int id);
    Collection<T> list();
    void deleteById(int id);
}
