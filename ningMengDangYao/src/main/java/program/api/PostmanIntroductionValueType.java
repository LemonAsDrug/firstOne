package program.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import program.utils.H;
import program.utils_other.P;
import program.utils_other.R;

@RestController
@RequestMapping("/postman")
public class PostmanIntroductionValueType{

    @PostMapping("/getIntroValue")
    public R getIntroValue(@RequestBody P p){
        System.out.println(p.get("name"));
        System.out.println(p.get("name").getClass().toString());
        System.out.println(p.get("age"));
        System.out.println(p.get("age").getClass().toString());
        System.out.println(p.get("friendsList"));
        System.out.println(p.get("friendsList").getClass().toString());
        System.out.println(p.get("friendsMap"));
        System.out.println(p.get("friendsMap").getClass().toString());
        return R.ok();
    }

    @PostMapping("/testExtendsMethod")
    public R testExtendsMethod(@RequestBody H h){
        System.out.println(h.get("name").getClass().toString());
        System.out.println(h.get("age").getClass().toString());


        return R.ok();
    }



    /**
     * 测试工具类  H
     * @param h
     * @return
     */
    @PostMapping("/testHExtendHashmap")
    public R testHExtendHashmap(@RequestBody H h){
        /**
         * 工具类H继承了HashMap类，没有写别的方法，get只有三个方法
         * h.get()
         * h.getOrDefault()
         * h.getClass()
         */

        /**
         * 传入字符串，默认是String
         */
        System.out.println(h.get("name").getClass());

        /**
         * 传入数值，默认是Integer类
         */
        System.out.println(h.get("age").getClass());
        System.out.println("_________________________________");

        System.out.println(h.get("friendsList"));
        System.out.println(h.get("friendsList").getClass());
        System.out.println(h.get("friendsMap"));
        System.out.println(h.get("friendsMap").getClass());

        /**
         * 方法效果，如果没传入这个键值对，获取默认的后面的值
         */
        System.out.println(h.getOrDefault("gender", 0).getClass());
        System.out.println(h.getOrDefault("gender", "1").getClass());


        return R.ok();
    }
}
