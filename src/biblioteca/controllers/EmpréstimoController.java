package biblioteca.controllers;

import biblioteca.models.Pedidos.Empréstimo;

public interface EmpréstimoController {
	void adicionar(Empréstimo emprestimo);
	void remover(Empréstimo emprestimo);
	void consultar();
}