package cn.alandelip.web.data;

/**
 * <b>返回统一格式</b><br>
 * {<br>
 * status:"success | fail",<br>
 * errorCode:"",<br>
 * data:{}<br>
 * }<br><br>
 * 对外提供构造器(可链式调用)和data为Boolean普通构造器{@link Response#success()}和{@link Response#fail(String errorCode)}静态函数</b>
 *
 * TODO 这个类写的有问题，builder的设计不对，之后会改一下
 * @author Alan on 2017/3/14
 */
public class Response<T> {
	private String status;
	private String errorCode;
	private T data;

	public String getStatus() {
		return status;
	}

	private void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	private void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public T getData() {
		return data;
	}

	private void setData(T data) {
		this.data = data;
	}

	public Response<T> succ() {
		status = "success";
		return this;
	}

	public Response<T> fail() {
		status = "fail";
		return this;
	}

	public Response<T> code(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public Response<T> data(T data) {
		this.data = data;
		return this;
	}

	public Response<T> build() {
		return this;
	}

	/**
	 * 返回成功的Response包装
	 *
	 * @return Response
	 */
	public static Response success() {
		Response<Boolean> response = new Response<>();
		response.setStatus("success");
		response.setData(true);
		return response;
	}

	/**
	 * 返回失败的Response包装
	 *
	 * @param errorCode 错误码
	 * @return Response
	 */
	public static Response fail(String errorCode) {
		Response<Boolean> response = new Response<>();
		response.setStatus("fail");
		response.setErrorCode(errorCode);
		response.setData(false);
		return response;
	}
}
