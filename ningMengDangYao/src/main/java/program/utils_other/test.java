package program.utils_other;

public class test {

    public static void main(String[] args) {

        Long monthmillseconds =2*31*86400*1000L;
        Long weekmillseconds =7*86400*1000L;

        System.out.println(System.currentTimeMillis()-2*weekmillseconds);
        System.out.println(System.currentTimeMillis()-weekmillseconds);
        System.out.println("now:" + System.currentTimeMillis());
        System.out.println("______________");
        long now = System.currentTimeMillis();
        System.out.println(now+monthmillseconds);

    }
}
