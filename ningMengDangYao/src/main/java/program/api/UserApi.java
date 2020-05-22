package program.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import program.service.UserService;

@RestController
@RequestMapping("/User")
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public void test() {
        System.out.println("插入5个用户");
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);
    }

}
