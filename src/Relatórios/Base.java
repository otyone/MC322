package Relatórios;
import ItemMultimidia.*;
import Membros.*;
import Pedidos.*;

abstract class Base {
	private Item[] Objetos;
	private Membro[] Pessoas;
	private Pedido[] Comissões;
	public Base() {
		Objetos = null;
		Pessoas = null;
		Comissões = null;
	}
	public Base(Item[] objetos, Membro[] pessoas, Pedido[] comissões) {
		Objetos = objetos;
		Pessoas = pessoas;
		Comissões = comissões;
	}
	public Item[] getObjetos() {
		return Objetos;
	}
	public void setObjetos(Item[] objetos) {
		Objetos = objetos;
	}
	public Membro[] getPessoas() {
		return Pessoas;
	}
	public void setPessoas(Membro[] pessoas) {
		Pessoas = pessoas;
	}
	public Pedido[] getComissões() {
		return Comissões;
	}
	public void setComissões(Pedido[] comissões) {
		Comissões = comissões;
	}
}
