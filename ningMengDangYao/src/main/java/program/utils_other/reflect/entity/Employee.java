package program.utils_other.reflect.entity;

import lombok.Data;

@Data
public class Employee {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0女1男
     */
    private Integer gender;

    private Integer age;

    private Integer add5(Integer age){
        age = age + 5;
        return age;
    }
}
