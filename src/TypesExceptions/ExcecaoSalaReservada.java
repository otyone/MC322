package TypesExceptions;

public class ExcecaoSalaReservada extends Exception {

	public ExcecaoSalaReservada() {
		super();
	}

	public ExcecaoSalaReservada(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoSalaReservada(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoSalaReservada(String message) {
		super(message);
	}

	public ExcecaoSalaReservada(Throwable cause) {
		super(cause);
	}
}