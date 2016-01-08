package tiscon1.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author kawasima
 */
@Data
public class LoginForm implements Serializable {
    @NotNull
    private String account;

    @NotNull
    private String password;
}
