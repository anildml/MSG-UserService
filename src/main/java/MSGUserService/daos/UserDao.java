package MSGUserService.daos;

import MSGUserService.models.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Long> {

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
            @Param("userCode") long userCode
    );

}
