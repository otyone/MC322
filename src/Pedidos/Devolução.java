package Pedidos;

import ItemMultimidia.Item;
import Membros.Membro;

public class Devolução extends Pedido{

	public Devolução() {
		super();
	}

	public Devolução(Item objeto, Membro pedinte) {
		super(objeto, pedinte);
	}
	
}
