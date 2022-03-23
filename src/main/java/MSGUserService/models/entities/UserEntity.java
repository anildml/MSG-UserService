package MSGUserService.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigDecimal id;

    @Column(name = "username")
    private String username;

    @Column(name = "password_digest")
    private String passwordDigest;

    @Column(name = "user_code")
    private BigDecimal userCode;

    @Column(name = "email")
    private String email;

}
