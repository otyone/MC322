package Pedidos;

import ItemMultimidia.Item;
import Membros.Membro;

public class Reserva extends Pedido{

	public Reserva() {
		super();
	}

	public Reserva(Item objeto, Membro pedinte) {
		super(objeto, pedinte);
	}
	
}