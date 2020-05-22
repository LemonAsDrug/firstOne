package program.utils_other.call_callingInterface;

import program.utils_other.call_callingInterface.impl.CallingInterfaceImpl;

public class interface_test {
    public static void main(String[] args) {
        //CallingInterface callingInterface;
        //只声明接口对象不行

        CallingInterface callingInterface = new CallingInterfaceImpl();
        //声明接口对象的同时，并为对象分配内存空间

        String name = callingInterface.getName();
        System.out.println(name);
        Integer age = callingInterface.getAge();
        System.out.println(age);


    }
}
