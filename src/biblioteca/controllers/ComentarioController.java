package biblioteca.controllers;

import biblioteca.models.*;

public interface ComentarioController {
	void adicionar(Comentario comentario);
	void remover(Comentario comentario);
	void consultar();
}