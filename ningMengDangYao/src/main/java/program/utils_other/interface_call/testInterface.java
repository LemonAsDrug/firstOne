package program.utils_other.interface_call;

/**
 * 单个类 调用接口的方法
 */
public class testInterface {
    public static void main(String[] args) {
        Duck d = new Duck();
        testInterface.test1(d);

    }

    public static void test1(Runner r) {// Runner r = new Duck();
        r.run();
    }
    public static void test2(Swimmer s) {// Swimmer w = new Duck();
        s.swim();
    }
    public static void test3(Flier f) {// Flier f = new Duck();
        f.fly();
    }


}
interface Runner{
    void run();
}
interface Swimmer{
    void swim();
}
interface Flier{
    void fly();
}
class Duck implements Runner,Swimmer,Flier{

    @Override
    public void fly() {
        System.out.println("我会飞");
        // TODO Auto-generated method stub

    }

    @Override
    public void swim() {
        System.out.println("我会游泳");
        // TODO Auto-generated method stub

    }

    @Override
    public void run() {
        System.out.println("我会奔跑");
        // TODO Auto-generated method stub

    }

}

