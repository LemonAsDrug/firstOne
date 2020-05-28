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
        user.setNick_name("wucunyang");
        user.setHead_pic("http://att3.citysbs.com/200x200/hangzhou/2020/04/15/11/dd6719bd4287d9efd49434c43563a032_v2_.jpg");
        userMapper.insert(user);
    }

}
