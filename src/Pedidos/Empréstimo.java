package Pedidos;

import ItemMultimidia.Item;
import Membros.Membro;

public class Empréstimo extends Pedido {

	public Empréstimo() {
		super();
	}

	public Empréstimo(Item objeto, Membro pedinte) {
		super(objeto, pedinte);
	}
	
}
