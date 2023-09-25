package Generics;

import biblioteca.models.ItemMultimidia;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaEmpréstimosImpl<T extends ItemMultimidia> implements ListaEmpréstimos<T> {
	List<T> ListaEmprestimos = new LinkedList<T>();
	
	public ListaEmpréstimosImpl() {}
	
	public ListaEmpréstimosImpl(List<T> listaEmprestimos) {
		ListaEmprestimos = listaEmprestimos;
	}

	public List<T> getListaEmprestimos() {
		return ListaEmprestimos;
	}

	public void setListaEmprestimos(List<T> listaEmprestimos) {
		ListaEmprestimos = listaEmprestimos;
	}

	@Override
	public void mostrarEmpréstimos() {
		if(ListaEmprestimos == null) {
			System.out.println("Vazio!");
			System.out.println();
			return;
		}
    	Iterator<T> it = ListaEmprestimos.iterator(); //definir iterator
    	while(it.hasNext()) {
    		T check = it.next();
    		System.out.println(check.getClass());
    		System.out.println();
    	}
	}

	@Override
	public boolean Emprestar(T objeto) {
		if(ListaEmprestimos == null) {
			ListaEmprestimos.add(objeto);
			System.out.println("Emprestado!");
			System.out.println();
			return true;
		}
		if(ListaEmprestimos.contains(objeto)) {
			System.out.println("Já emprestado!");
			System.out.println();
		}else {
			ListaEmprestimos.add(objeto);
			System.out.println("Emprestado!");
			System.out.println();
			return true;
		}
		return false;
	}

	@Override
	public boolean Remover(T objeto) {
		if(ListaEmprestimos == null) {
			System.out.println("Vazio!");
			System.out.println();
			return false;
		}
		if(ListaEmprestimos.contains(objeto)) {
			ListaEmprestimos.remove(objeto);
			System.out.println("Removido!");
			System.out.println();
			return true;
		}else {
			System.out.println("Não existe esse empréstimo!");
			System.out.println();
			return false;
		}
	}
}