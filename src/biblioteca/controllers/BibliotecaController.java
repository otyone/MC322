package biblioteca.controllers;

import java.util.List;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;

public interface BibliotecaController {
    List<Item> consultarItensDisponiveis();
    boolean emprestarItem(MembroM membro, Item item);
    boolean devolverItem(MembroM membro, Item item);
}