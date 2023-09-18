package biblioteca.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import biblioteca.models.Membros.*;

public class MembroControllerImpl implements MembroController {
    private List<MembroM> membros;

    public MembroControllerImpl() {
        membros = new ArrayList<>();
    }

    @Override
    public List<MembroM> listarMembros() {
        return membros;
    }

    @Override
    public MembroM buscarMembroPorIdentificacao(String identificacao) {
        // Lógica de busca
    	if(membros == null) {
    		return null;
    	}
        String Nome = identificacao;
        Iterator<MembroM> it = membros.iterator();
        while(it.hasNext()) {
        	MembroM test = it.next();
        	if(test.getNome() == Nome) {
        		return test;
        	}
        }
    	return null;
    }
}