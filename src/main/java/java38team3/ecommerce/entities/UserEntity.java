package java38team3.ecommerce.entities;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;


    // @Email
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;


}
