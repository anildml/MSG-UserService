package MSGUserService.daos;

import MSGUserService.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    @Query("" +
            "SELECT u " +
            "FROM UserEntity u " +
            "WHERE (" +
            "   u.username = :username" +
            ")")
    UserEntity findUserEntityByUsername(
            @Param("username") String username
    );

    @Query("" +
            "SELECT u " +
            "FROM UserEntity u " +
            "WHERE (" +
            "   u.userCode = :userCode" +
            ")")
    UserEntity findUserEntityByUserCode(
            @Param("userCode") BigDecimal userCode
    );

}
