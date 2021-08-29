package MSGUserService.services;

import MSGUserService.daos.UserDao;
import MSGUserService.helpers.AuthHelper;
import MSGUserService.helpers.DtoMapper;
import MSGUserService.helpers.PasswordHandler;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public interface UserService {

    List<UserEntity> test();

    String loginAndGetToken(UserDto userDto);

    Boolean signUp(UserDto userDto);

}

class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordHandler passwordHandler;

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private DtoMapper dtoMapper;

    public List<UserEntity> test() {
        return StreamSupport
                .stream(userDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public String loginAndGetToken(UserDto userDto) {
        UserEntity userEntity = userDao.findUserEntityByUserName(userDto.getUserName());
        if (passwordHandler.doesPasswordsMatch(userEntity.getPasswordDigest(), userDto.getPassword())) {
            return authHelper.buildTokenForUser(userDto);
        }
        return null;
    }

    @Override
    public Boolean signUp(UserDto userDto) {
        UserEntity userEntity = dtoMapper.convertToEntity(userDto);
        try {
            userDao.save(userEntity);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
