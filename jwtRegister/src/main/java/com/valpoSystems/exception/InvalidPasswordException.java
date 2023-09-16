package com.valpoSystems.exception;

public class InvalidPasswordException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException() {
    }

    public InvalidPasswordException(final String message) {
        super(message);
    }

    public InvalidPasswordException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidPasswordException(final Throwable cause) {
        super(cause);
    }

    public InvalidPasswordException(final String message, final Throwable cause, final boolean enableSuppression,
                         final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
