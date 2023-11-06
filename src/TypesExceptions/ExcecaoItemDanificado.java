package TypesExceptions;

public class ExcecaoItemDanificado extends Exception {

	public ExcecaoItemDanificado() {
		super();
	}

	public ExcecaoItemDanificado(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoItemDanificado(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoItemDanificado(String message) {
		super(message);
	}

	public ExcecaoItemDanificado(Throwable cause) {
		super(cause);
	}
}