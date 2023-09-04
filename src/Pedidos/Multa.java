package Pedidos;

import ItemMultimidia.Item;
import Membros.Membro;

public class Multa extends Pedido{

	public Multa() {
		super();
	}

	public Multa(Item objeto, Membro pedinte) {
		super(objeto, pedinte);
	}
	
}
