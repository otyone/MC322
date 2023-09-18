package biblioteca.views;

import java.util.List;
import java.util.Iterator;

import biblioteca.controllers.MembroController;
import biblioteca.models.Membros.*;

public class MembroViewImpl implements MembroView {
    private MembroController membroController;

    public MembroViewImpl(MembroController controller) {
        membroController = controller;
    }

    public MembroController getMembroController() {
		return membroController;
	}

	public void setMembroController(MembroController membroController) {
		this.membroController = membroController;
	}

	@Override
    public void mostrarListaMembros(List<MembroM> membros) {
        // Implementação da exibição da lista de membros
		if(membros == null) {
			System.out.println("Não há membros");
			System.out.println();
			return;
		}
		Iterator<MembroM> it = membros.iterator();
		while(it.hasNext()) {
			MembroM test = it.next();
			System.out.println("Nome:" + test.getNome());
			System.out.println();
		}
    }

    @Override
    public void mostrarDetalhesMembro(MembroM membro) {
        // Implementação da exibição dos detalhes de um membro
    	System.out.println(membro.getNome() + membro.getIdentificacao());
    }
}