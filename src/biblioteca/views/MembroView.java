package biblioteca.views;

import java.util.List;

import biblioteca.models.Membros.*;

public interface MembroView {
    void mostrarListaMembros(List<MembroM> membros);
    void mostrarDetalhesMembro(MembroM membro);
}