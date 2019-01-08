package cn.alandelip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alan on 2017/6/6
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
	public ForbiddenException(String message) {
		super(message);
	}
}
