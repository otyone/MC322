package TypesExceptions;

public class ExcecaoIDExistente extends Exception {

	public ExcecaoIDExistente() {
		super();
	}

	public ExcecaoIDExistente(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoIDExistente(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoIDExistente(String message) {
		super(message);
	}

	public ExcecaoIDExistente(Throwable cause) {
		super(cause);
	}
}