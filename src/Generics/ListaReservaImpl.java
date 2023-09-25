package Generics;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaReservaImpl<T> implements ListaReserva<T>{
	List<T> ListaReserva = new LinkedList<T>();
	
	public ListaReservaImpl() {}

	public List<T> getListaReserva() {
		return ListaReserva;
	}

	public void setListaReserva(List<T> listaReserva) {
		ListaReserva = listaReserva;
	}

	public ListaReservaImpl(List<T> listaReserva) {
		ListaReserva = listaReserva;
	}

	@Override
	public void mostrarReservas() {
		if(ListaReserva == null) {
			System.out.println("Vazio!");
			System.out.println();
			return;
		}
    	Iterator<T> it = ListaReserva.iterator(); //definir iterator
    	while(it.hasNext()) {
    		T check = it.next();
    		System.out.println(check.getClass());
    		System.out.println();
    	}
	}

	@Override
	public boolean Reservar(T objeto) {
		if(ListaReserva == null) {
			ListaReserva.add(objeto);
			System.out.println("Reservado!");
			System.out.println();
			return true;
		}
		if(ListaReserva.contains(objeto)) {
			System.out.println("Já reservado!");
			System.out.println();
		}else {
			ListaReserva.add(objeto);
			System.out.println("Reservado!");
			System.out.println();
			return true;
		}
		return false;
	}

	@Override
	public boolean Remover(T objeto) {
		if(ListaReserva == null) {
			System.out.println("Vazio!");
			System.out.println();
			return false;
		}
		if(ListaReserva.contains(objeto)) {
			ListaReserva.remove(objeto);
			System.out.println("Removido!");
			System.out.println();
			return true;
		}else {
			System.out.println("Não existe essa reserva!");
			System.out.println();
			return false;
		}
	}
}