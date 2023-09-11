package biblioteca.models.Pedidos;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;

public class Multa extends Pedido{

	public Multa() {
		super();
	}

	public Multa(Item objeto, MembroM pedinte) {
		super(objeto, pedinte);
	}
	
}
