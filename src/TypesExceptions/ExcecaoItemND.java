package TypesExceptions;

public class ExcecaoItemND extends Exception {

	public ExcecaoItemND() {
		super();
	}

	public ExcecaoItemND(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoItemND(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoItemND(String message) {
		super(message);
	}

	public ExcecaoItemND(Throwable cause) {
		super(cause);
	}
}