package TypesExceptions;

public class ExcecaoDadoInvalido extends Exception {

	public ExcecaoDadoInvalido() {
		super();
	}

	public ExcecaoDadoInvalido(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoDadoInvalido(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoDadoInvalido(String message) {
		super(message);
	}

	public ExcecaoDadoInvalido(Throwable cause) {
		super(cause);
	}
}