package MSGUserService.daos;

import MSGUserService.models.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Long> {

    UserEntity findUserEntityByUserName(String username);

}
