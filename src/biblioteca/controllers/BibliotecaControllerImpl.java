package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;

import biblioteca.models.ItemMulti.*;
import biblioteca.models.Membros.*;
import biblioteca.models.Pedidos.*;

public class BibliotecaControllerImpl implements BibliotecaController {
    private List<Item> itens;

    public BibliotecaControllerImpl() {
        itens = new ArrayList<>();
    }

    @Override
    public List<Item> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public boolean emprestarItem(MembroM membro, Item item) {
        // Lógica de empréstimo
    	Empréstimo emprestimo = new Empréstimo(item, membro);
    	membro.adicionar(emprestimo);
    	System.out.println("Empréstimo realizado!");
    	System.out.println();
        return true;
    }

    @Override
    public boolean devolverItem(MembroM membro, Item item) {
        // Lógica de devolução
        return true;
    }
}