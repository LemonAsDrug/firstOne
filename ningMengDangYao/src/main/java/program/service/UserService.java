package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.entity.user;
import program.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void create(String name,Integer age){
        user user = new user();
        user.setName(name);
        user.setAge(age);
        userMapper.insert(user);
    }

}
