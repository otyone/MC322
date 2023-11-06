package TypesExceptions;

public class ExcecaoItemNEmp extends Exception {

	public ExcecaoItemNEmp() {
		super();
	}

	public ExcecaoItemNEmp(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoItemNEmp(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoItemNEmp(String message) {
		super(message);
	}

	public ExcecaoItemNEmp(Throwable cause) {
		super(cause);
	}
}