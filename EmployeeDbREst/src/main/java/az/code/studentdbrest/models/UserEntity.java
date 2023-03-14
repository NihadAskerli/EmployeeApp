package az.code.studentdbrest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "UserEntity")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_product"
    )
    @SequenceGenerator(
            name = "seq_product",
            allocationSize = 1
    )
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @ElementCollection
    private List<Role> role;
}
