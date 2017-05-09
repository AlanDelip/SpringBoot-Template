package cn.alandelip.web.data;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * <b>返回统一格式</b><br>
 * {<br>
 * status:"success | fail",<br>
 * errorCode:"",<br>
 * data:{}<br>
 * }<br><br>
 * 对外提供构造器(可链式调用){@link Builder}
 *
 * @author Alan on 2017/3/14
 */
public class Response<T> {
	private String status;
	private String errorCode;
	private T data;

	public String getStatus() {
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public T getData() {
		return data;
	}

	/**
	 * 返回失败的Response包装
	 *
	 * @param errorCode 错误码
	 * @return Response
	 */
	public static String fail(String errorCode) {
		return new Response<Boolean>().getBuilder().failBuild(errorCode);
	}

	/**
	 * 返回成功的Response包装
	 *
	 * @return Response
	 */
	public static String success() {
		return new Response<Boolean>().getBuilder().succ().build();
	}

	public Builder getBuilder() {
		return new Builder();
	}

	public class Builder implements Serializable {
		public String failBuild(String msg) {
			status("fail");
			message(msg);
			data(null);
			return new Gson().toJson(Response.this);
		}

		public Builder succ() {
			status = "success";
			return this;
		}

		public Builder fail() {
			status = "fail";
			return this;
		}

		public Builder status(String buildStatus) {
			status = buildStatus;
			return this;
		}

		public Builder message(String msg) {
			errorCode = msg;
			return this;
		}

		public Builder data(T buildData) {
			data = buildData;
			return this;
		}

		public String build() {
			return new Gson().toJson(Response.this);
		}
	}
}
