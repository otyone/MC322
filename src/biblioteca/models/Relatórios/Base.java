package biblioteca.models.Relatórios;
import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;
import biblioteca.models.Pedidos.*;

abstract class Base {
	private Item[] Objetos;
	private MembroM[] Pessoas;
	private Pedido[] Comissões;
	public Base() {
		Objetos = null;
		Pessoas = null;
		Comissões = null;
	}
	public Base(Item[] objetos, MembroM[] pessoas, Pedido[] comissões) {
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
	public MembroM[] getPessoas() {
		return Pessoas;
	}
	public void setPessoas(MembroM[] pessoas) {
		Pessoas = pessoas;
	}
	public Pedido[] getComissões() {
		return Comissões;
	}
	public void setComissões(Pedido[] comissões) {
		Comissões = comissões;
	}
}
