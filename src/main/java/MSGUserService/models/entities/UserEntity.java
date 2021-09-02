package MSGUserService.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_code")
    private long userCode;

    @Column(name = "email")
    private String email;

    @Column(name = "password_digest")
    private String passwordDigest;

}
