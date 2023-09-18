package biblioteca.controllers;

import java.util.List;

import biblioteca.models.Membros.MembroM;

public interface MembroController {
    List<MembroM> listarMembros();
    MembroM buscarMembroPorIdentificacao(String identificacao);
}