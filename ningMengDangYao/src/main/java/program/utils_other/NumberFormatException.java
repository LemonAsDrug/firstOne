package program.utils_other;

public class NumberFormatException {
    public static void main(String[] args) {
/**
 * Exception in thread "main" java.lang.NumberFormatException: For input string: "1 "
 * 错误：数字格式异常
 */
        String str = "1 ";
//        System.out.println(Integer.parseInt(str));

        //trim() 方法用于删除字符串的头尾空白符。
//        System.out.println(Integer.parseInt(str.trim()));

        System.out.println(Integer.parseInt(str.replace(" ","")));




//        别的，分割字符串的方法
        String str2 = "1,2,3,4,5,6";
        for (String retval: str2.split(",", 0)) {
            System.out.println(retval);
        }


    }
}
