package Generics;

import biblioteca.models.ItemMultimidia;

public interface ListaEmpréstimos<T extends ItemMultimidia> {
	void mostrarEmpréstimos();
	boolean Emprestar(T objeto);
	boolean Remover(T objeto);
}