package biblioteca.models.Pedidos;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;

public class Devolução extends Pedido{

	public Devolução() {
		super();
	}

	public Devolução(Item objeto, MembroM pedinte) {
		super(objeto, pedinte);
	}
	
}
