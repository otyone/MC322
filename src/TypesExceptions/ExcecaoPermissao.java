package TypesExceptions;

public class ExcecaoPermissao extends Exception {

	public ExcecaoPermissao() {
		super();
	}

	public ExcecaoPermissao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoPermissao(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoPermissao(String message) {
		super(message);
	}

	public ExcecaoPermissao(Throwable cause) {
		super(cause);
	}
}