package TypesExceptions;

public class ExcecaoMultaPendente extends Exception {

	public ExcecaoMultaPendente() {
		super();
	}

	public ExcecaoMultaPendente(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoMultaPendente(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoMultaPendente(String message) {
		super(message);
	}

	public ExcecaoMultaPendente(Throwable cause) {
		super(cause);
	}
}