package tiscon1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author kawasima
 */
@Entity
@Data
@RequiredArgsConstructor
public class Prefecture implements Serializable {
    @Id
    private String prefectureCd;

    private String name;
}
