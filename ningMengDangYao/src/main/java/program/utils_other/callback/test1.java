package program.utils_other.callback;



import java.lang.reflect.Method;

public class test1 {
    public static void main(String[] args) {

        try {
            Class<?> employee = Class.forName("program.utils_other.reflect.entity.Employee");
            System.out.println(employee);
            System.out.println(employee.getName());
            Method[] methods = employee.getMethods();
            for (Method method:methods){
                System.out.println(method.getName());
            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
