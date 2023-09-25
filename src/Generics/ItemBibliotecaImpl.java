package Generics;

import biblioteca.models.ItemMultimidia;
import java.util.List;
import java.util.LinkedList;

public class ItemBibliotecaImpl<T extends ItemMultimidia> implements ItemBiblioteca<T> {
	List<T> itensReservados = new LinkedList<>();
	List<T> itensEmprestados = new LinkedList<>();
	int numRes, numEmp;
	public ItemBibliotecaImpl() {
		this.numRes = 0;
		this.numEmp = 0;
	}
	public ItemBibliotecaImpl(List<T> itensReservados, List<T> itensEmprestados, int numRes, int numEmp) {
		this.itensReservados = itensReservados;
		this.itensEmprestados = itensEmprestados;
		this.numRes = numRes;
		this.numEmp = numEmp;
	}
	public List<T> getItensReservados() {
		return itensReservados;
	}
	public void setItensReservados(List<T> itensReservados) {
		this.itensReservados = itensReservados;
	}
	public List<T> getItensEmprestados() {
		return itensEmprestados;
	}
	public void setItensEmprestados(List<T> itensEmprestados) {
		this.itensEmprestados = itensEmprestados;
	}
	public int getNumRes() {
		return numRes;
	}
	public void setNumRes(int numRes) {
		this.numRes = numRes;
	}
	public int getNumEmp() {
		return numEmp;
	}
	public void setNumEmp(int numEmp) {
		this.numEmp = numEmp;
	}
	@Override
	public boolean ReservarItem(T item) {
		if(itensReservados == null) {
			itensReservados.add(item);
			System.out.println("Item reservado!");
			System.out.println();
			return true;
		}
		if(itensReservados.contains(item)) {
			System.out.println("Item já reservado!");
			System.out.println();
		}else {
			itensReservados.add(item);
			System.out.println("Item reservado!");
			System.out.println();
			return true;
		}
		return false;
	}
	@Override
	public boolean EmprestarItem(T item) {
		if(itensEmprestados == null) {
			itensEmprestados.add(item);
			System.out.println("Item emprestado!");
			System.out.println();
			return true;
		}
		if(itensEmprestados.contains(item)) {
			System.out.println("Item já emprestado!");
			System.out.println();
		}else {
			itensEmprestados.add(item);
			System.out.println("Item emprestado!");
			System.out.println();
			return true;
		}
		return false;
	}
	@Override
	public boolean DevolverItem(T item) {
		if(itensEmprestados == null) {
			System.out.println("Vazio!");
			System.out.println();
			return false;
		}
		if(itensEmprestados.contains(item)) {
			itensEmprestados.remove(item);
			System.out.println("Item devolvido!");
			System.out.println();
			return true;
		}else {
			System.out.println("Item não foi emprestado!");
			System.out.println();
			return false;
		}
	}
}