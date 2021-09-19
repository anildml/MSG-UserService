package MSGUserService.daos;

import MSGUserService.models.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
    UserEntity findUserEntityByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.userCode = ?1")
    UserEntity findUserEntityByUserCode(long userCode);

}
