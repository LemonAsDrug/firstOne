package program.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @author zhangjintao
 * @date 2019年4月15日 下午2:04:27
 */
@Data
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public BaseException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BaseException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public BaseException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public BaseException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}
	
	
}
