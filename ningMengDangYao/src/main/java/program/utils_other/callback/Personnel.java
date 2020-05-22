package program.utils_other.callback;

public class Personnel {

    public void doSomething(Manager manager,String task){
        System.out.println("老板让你做" + task);

        String result = "做完了";
        manager.phoneCall(result);
    }
}
