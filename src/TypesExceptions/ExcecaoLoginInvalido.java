package TypesExceptions;

public class ExcecaoLoginInvalido extends Exception {

	public ExcecaoLoginInvalido() {
		super();
	}

	public ExcecaoLoginInvalido(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoLoginInvalido(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoLoginInvalido(String message) {
		super(message);
	}

	public ExcecaoLoginInvalido(Throwable cause) {
		super(cause);
	}
}