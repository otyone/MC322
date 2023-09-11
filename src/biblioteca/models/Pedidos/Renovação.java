package biblioteca.models.Pedidos;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;

public class Renovação extends Pedido {

	public Renovação() {
		super();
	}

	public Renovação(Item objeto, MembroM pedinte) {
		super(objeto, pedinte);
	}
	
}
