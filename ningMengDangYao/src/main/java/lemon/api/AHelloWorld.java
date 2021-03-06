package lemon.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  控制层 类的命名方式和工具类相同。
 *  命名方法：首字母不小写，每个单词的首字母大写
 *
 */

@Controller
@RequestMapping("/test")
public class AHelloWorld {

    //以下是spring mvc的功能
    @ResponseBody //作用:把方法返回的"hello world"写给浏览器
    @RequestMapping("/hello") //作用：接受来自浏览器的hello请求  http://localhost:8080/hello 后的/hello就是hello请求
    public String hello(){
        return "hello.world";
    }


}