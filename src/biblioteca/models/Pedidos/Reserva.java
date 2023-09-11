package biblioteca.models.Pedidos;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;

public class Reserva extends Pedido{

	public Reserva() {
		super();
	}

	public Reserva(Item objeto, MembroM pedinte) {
		super(objeto, pedinte);
	}
	
}