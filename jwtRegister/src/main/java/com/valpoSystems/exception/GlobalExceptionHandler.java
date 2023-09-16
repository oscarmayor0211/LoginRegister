package com.valpoSystems.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.valpoSystems.domain.response.ErrorResponse;

import java.io.Serializable;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler implements Serializable {

	private static final long serialVersionUID = 1L;

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleBusinessException(final Exception ex) {
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleBusinessException(final UserException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(InvalidPasswordException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleBusinessException(final InvalidPasswordException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", ")));
	}

}
