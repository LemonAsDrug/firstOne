package program.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import program.utils_other.service.impl.NatureMultiImpl;

/**
 *  控制层 类的命名方式和工具类相同。
 *  命名方法：首字母不小写，每个单词的首字母大写
 *
 */

@Controller
@RequestMapping("/test")
public class AHelloWorld {

    @Autowired
    NatureMultiImpl natureMulti;

    //以下 都是以前spring mvc的功能
    @ResponseBody //作用:把方法返回的"hello world"写给浏览器
    @RequestMapping("/hello") //作用：接受来自浏览器的hello请求  http://localhost:8080/hello 后的/hello就是hello请求
    public String hello(){
        return "hello.world";
    }

    @RequestMapping("/testCloud")
    public String testCloud(){
        return natureMulti.getCloud();
    }

    @RequestMapping("/testSea")
    public String testSea(){
        return natureMulti.getFish();
    }

}