package tiscon1.model;

import java.io.Serializable;
import java.security.Principal;

/**
 * @author kawasima
 */
public class UserPrincipal implements Principal, Serializable {
    private String name;

    public UserPrincipal() {

    }

    public UserPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
