package MSGUserService.daos.UserDao;

import MSGUserService.models.mariadbModels.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserDao {



}

interface UserDaoMariaDbImpl extends UserDao, CrudRepository<AppUser, Long> {

}

class UserDaoMongoImpl implements UserDao {

}
