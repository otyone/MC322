package biblioteca.models.Pedidos;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;

public class Empréstimo extends Pedido {

	public Empréstimo() {
		super();
	}

	public Empréstimo(Item objeto, MembroM pedinte) {
		super(objeto, pedinte);
	}
	
}
