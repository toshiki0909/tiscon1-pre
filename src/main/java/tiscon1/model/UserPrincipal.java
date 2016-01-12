package tiscon1.model;

import java.io.Serializable;
import java.security.Principal;

/**
 * @author kawasima
 */
public class UserPrincipal implements Principal, Serializable {
    private String name;
    private long id;

    public UserPrincipal() {

    }

    public UserPrincipal(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public long getId() { return id;}

    public void setName(String name) {
        this.name = name;
    }
}
