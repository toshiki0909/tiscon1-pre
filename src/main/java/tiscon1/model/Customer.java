package tiscon1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author kawasima
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String firstName;

    private String lastName;

    private String company;

    private String telephoneNumber;

    private Prefecture prefecture;

    private String address;
}
