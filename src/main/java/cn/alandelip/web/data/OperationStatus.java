package cn.alandelip.web.data;

/**
 * 操作返回状态
 *
 * @author Alan on 2017/6/6
 */
public class OperationStatus {
	private String status;
	private String msg;

	public OperationStatus(Status status) {
		this(status, "");
	}

	public OperationStatus(Status status, String msg) {
		this.status = status.name().toLowerCase();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public enum Status {
		/**
		 * 正在处理
		 */
		PENDING,
		/**
		 * 成功
		 */
		SUCCESS,
		/**
		 * 失败
		 */
		FAILURE;
	}
}
