package tiscon1.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author kawasima
 */
@Data
public class AccountRegisterForm implements Serializable {
    @Size(min = 1, max = 100)
    @NotNull
    private String name;


    @NotNull
    private String email;

    @Size(min = 6)
    @NotNull
    private String password;
}
