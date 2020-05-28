package lemon.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;

/**
 * 返回数据
 * @author zhangjintao
 * @date 2019年4月15日 下午2:04:27
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 200);
		put("msg", "success");
	}
	
	public static R error() {
		return error(HttpStatus.SC_UNPROCESSABLE_ENTITY, "操作失败");
	}
	
	public static R error(String msg) {
		return error(HttpStatus.SC_UNPROCESSABLE_ENTITY, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}


	public static R ok(Object data) {
		R r = new R();
		r.put("data", data);
		return r;
	}

	public static R ok(int code) {
		R r = new R();
		r.put("code", code);
		return r;
	}
	public static R ok() {
		return new R();
	}

	public boolean isOK(){
		if (200 == Integer.parseInt(this.get("code").toString())){
			return true;
		}
		return false;
	}
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
