package TypesExceptions;

public class ExcecaoLimiteEmprestimo extends Exception {

	public ExcecaoLimiteEmprestimo() {
		super();
	}

	public ExcecaoLimiteEmprestimo(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoLimiteEmprestimo(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoLimiteEmprestimo(String message) {
		super(message);
	}

	public ExcecaoLimiteEmprestimo(Throwable cause) {
		super(cause);
	}
}