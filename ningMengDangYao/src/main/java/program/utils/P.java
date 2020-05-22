package program.utils;

//
//import chong.find.exception.BaseException;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class P extends HashMap {


    public void check(String... necessaryParameter) {
        testParameter(necessaryParameter);
    }


    /**
     * 验证必要参数是否全部存在
     *
     * @param necessaryParameters 必要参数集合
     * @return 返回不存在的参数的字符串，以逗号隔开，如全存在则返回""
     */
    private void testParameter(String[] necessaryParameters) {
        StringBuffer notField = new StringBuffer();
        StringBuffer nullField = new StringBuffer();
        for (String necessaryParameter : necessaryParameters) {
            if (!this.containsKey(necessaryParameter)) {
                notField.append(necessaryParameter + ",");
            } else {
                if (this.get(necessaryParameter) == null) {
                    nullField.append(necessaryParameter + ",");
                }
            }
        }
        if (!"".equals(notField.toString())) {
            notField = new StringBuffer(notField.substring(0, notField.length() - 1));
            notField.append("参数不存在               ");
        }
        if (!"".equals(nullField.toString())) {
            nullField = new StringBuffer(nullField.substring(0, nullField.length() - 1));
            nullField.append("参数为NULL");
        }
//        String msg = notField.toString() + nullField.toString();
//        if (!"".equals(msg)) {
//            throw new BaseException(msg);
//        }
    }



//    /**
//     * 获取对象,转为json字符串
//     * @param key
//     * @return jsonStr
//     * */
//    public String getJsonVal(String key) {
//       return JSONObject.toJSONString(this.get(key));
//    }
//
//
//    /**
//     * 获取集合对象
//     * @param key
//     * @param toClass
//     * @return
//     * */
//    public  <T> List<T> getArr(String key, Class<T> toClass){
//        return  JSONArray.parseArray(getJsonVal(key),toClass);
//    }


    public Integer getInt(String key){
        return isNull(key)?0:Integer.parseInt(this.get(key).toString());
    }

    public Integer getInt(String key,boolean to0){
        if (to0){
            return getInt(key);
        }else {
            return isNull(key)?null:Integer.parseInt(this.get(key).toString());
        }
    }

    public Long getLong(String key){
        return isNull(key)?0l:Long.parseLong(this.get(key).toString());
    }

    public String getStr(String key){
        return isNull(key)?null:this.get(key).toString();
    }

    public BigDecimal getDecimal(String key){
        return new BigDecimal(isNull(key)?"0":this.get(key).toString());
    }

    private boolean isNull(String key){
        return this.get(key)==null||"".equals(this.get(key).toString());
    }
}
