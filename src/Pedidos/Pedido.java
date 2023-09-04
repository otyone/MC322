package Pedidos;
import ItemMultimidia.*;
import Membros.*;

public class Pedido {
	private Item Objeto;
	private Membro Pedinte;
	public Pedido() {
		Objeto = null;
		Pedinte = null;
	}
	public Pedido(Item objeto, Membro pedinte) {
		Objeto = objeto;
		Pedinte = pedinte;
	}
	public Item getObjeto() {
		return Objeto;
	}
	public void setObjeto(Item objeto) {
		Objeto = objeto;
	}
	public Membro getPedinte() {
		return Pedinte;
	}
	public void setPedinte(Membro pedinte) {
		Pedinte = pedinte;
	}
}
