package biblioteca.views;

import java.util.List;
import java.util.Iterator;

import biblioteca.controllers.BibliotecaController;
import biblioteca.models.ItemMulti.*;

public class BibliotecaViewImpl implements BibliotecaView {
    private BibliotecaController bibliotecaController;

    public BibliotecaViewImpl(BibliotecaController controller) {
        bibliotecaController = controller;
    }
    

    public BibliotecaController getBibliotecaController() {
		return bibliotecaController;
	}

	public void setBibliotecaController(BibliotecaController bibliotecaController) {
		this.bibliotecaController = bibliotecaController;
	}

	@Override
    public void mostrarItensDisponiveis(List<Item> itens) {
        // Implementação da exibição de itens disponíveis
		if(itens == null) {
			System.out.println("Não há itens disponíveis");
			System.out.println();
			return;
		}
    	Iterator<Item> it = itens.iterator();
    	while(it.hasNext()) {
    		Item test = it.next();
    		System.out.println("Título:" + test.getTitulo());
    	}
    	return;
    }

    @Override
    public void mostrarEmprestimoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Falha ao realizar o empréstimo.");
        }
    }

    @Override
    public void mostrarDevolucaoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Devolução realizada com sucesso.");
        } else {
            System.out.println("Falha ao realizar a devolução.");
        }
    }
}