package Generics;

public interface ListaReserva<T> {
	void mostrarReservas();
	boolean Reservar(T objeto);
	boolean Remover(T objeto);
}