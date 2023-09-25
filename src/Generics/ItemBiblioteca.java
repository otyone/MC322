package Generics;

import biblioteca.models.ItemMultimidia;

public interface ItemBiblioteca<T extends ItemMultimidia> {
	boolean ReservarItem(T item);
	boolean EmprestarItem(T item);
	boolean DevolverItem(T item);
}