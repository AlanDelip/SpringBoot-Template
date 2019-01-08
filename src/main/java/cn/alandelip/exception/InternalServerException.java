package cn.alandelip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alan.Zhufeng Xu, 1/8/2019.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {
	public InternalServerException(String message) {
		super(message);
	}
}
