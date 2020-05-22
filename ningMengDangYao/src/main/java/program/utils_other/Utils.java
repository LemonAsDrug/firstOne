package program.utils_other;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 常用工具
 *
 * Created by fanpengju on 2019/12/19 21:16.
 */
public class Utils {

    public static final BigDecimal ZERO = new BigDecimal("0");

    /**
     * 判断是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return "".equals(obj);
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }


    public static boolean isNotEmptyOrZero(Object num) {
        return !isEmptyOrZero(num);
    }

    public static boolean isEmptyOrZero(Object num) {
        if (Utils.isEmpty(num)) {
            return true;
        }
        if (num instanceof String) {
            return isEmptyOrZero(new BigDecimal((String) num));
        }
        if (num instanceof Integer) {
            return num.equals(0);
        }
        if (num instanceof Long) {
            return num.equals(0L);
        }
        if (num instanceof Double) {
            return num.equals(0D);
        }
        if (num instanceof Short) {
            return (Short) num == 0 ;
        }
        if (num instanceof Float) {
            return (Float) num == 0;
        }
        if (num instanceof Byte) {
            return (Byte) num == '0';
        }
        return false;
    }

    public static boolean isEmptyOrZero(BigDecimal num) {
        if (Utils.isEmpty(num)) {
            return true;
        }
        return ZERO.compareTo(num) == 0;
    }
    public static boolean isNotEmptyOrZero(BigDecimal num) {
        return !isEmptyOrZero(num);
    }

    public static Integer retZero() {
        return 0;
    }

    public static BigDecimal retZeroBigDecimal() {
        return ZERO;
    }

    public static boolean equals(Object a, Object b) {
        return Objects.equals(a, b);
    }


//    public static void main(String[] args) {
//        System.out.println(equals(1, 1));
//    }
}
