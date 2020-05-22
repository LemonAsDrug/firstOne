package program.utils_other.callback;

public class Manager implements CallBack {

    public Manager(Personnel personnel){
        personnel.doSomething(this,"整理公司文件");
    }


    @Override
    public void phoneCall(String result) {

    }
}
