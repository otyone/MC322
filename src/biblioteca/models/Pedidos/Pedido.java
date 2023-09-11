package biblioteca.models.Pedidos;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;

public class Pedido {
	private Item Objeto;
	private MembroM Pedinte;
	public Pedido() {
		Objeto = null;
		Pedinte = null;
	}
	public Pedido(Item objeto, MembroM pedinte) {
		Objeto = objeto;
		Pedinte = pedinte;
	}
	public Item getObjeto() {
		return Objeto;
	}
	public void setObjeto(Item objeto) {
		Objeto = objeto;
	}
	public MembroM getPedinte() {
		return Pedinte;
	}
	public void setPedinte(MembroM pedinte) {
		Pedinte = pedinte;
	}
}
