package biblioteca.models.Membros;

import biblioteca.models.*;
import biblioteca.controllers.EmpréstimoController;
import biblioteca.models.Pedidos.*;
import java.util.List;
import java.util.LinkedList;

public class MembroM implements Membro, EmpréstimoController {
	private String Nome, Identificacao; //atributos básicos de todo membro
	private int Contato, Data, LimiteEmprestimo, PrazoEmprestimo;
	private double MultaAtraso;
	List<Empréstimo> Empréstimos = new LinkedList<>(); 
	public MembroM() { //construtor padrão
		Nome = Identificacao = "Empty";
		Contato = LimiteEmprestimo = PrazoEmprestimo = Data = 0;
		MultaAtraso = 0;
		Empréstimos = null;
	}
	public MembroM(String nome, String identificacao, int contato, int data, int limiteEmprestimo, int prazoEmprestimo,
			double multaAtraso, List<Empréstimo> emprestimos) { //construtor específico
		Nome = nome;
		Identificacao = identificacao;
		Contato = contato;
		Data = data;
		LimiteEmprestimo = limiteEmprestimo;
		PrazoEmprestimo = prazoEmprestimo;
		MultaAtraso = multaAtraso;
		Empréstimos = emprestimos;
	}
	public String getNome() { //getters e setters
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getContato() {
		return Contato;
	}
	public void setContato(int contato) {
		Contato = contato;
	}
	public int getData() {
		return Data;
	}
	public void setData(int data) {
		Data = data;
	}
	@Override
	public String getIdentificacao() {
		return Identificacao;
	}
	@Override
	public int getLimiteEmprestimo() {
		return LimiteEmprestimo;
	}
	@Override
	public int getPrazoEmprestimo() {
		return PrazoEmprestimo;
	}
	@Override
	public double getMultaAtraso() {
		return MultaAtraso;
	}
	public void setIdentificacao(String identificacao) {
		Identificacao = identificacao;
	}
	public void setLimiteEmprestimo(int limiteEmprestimo) {
		LimiteEmprestimo = limiteEmprestimo;
	}
	public void setPrazoEmprestimo(int prazoEmprestimo) {
		PrazoEmprestimo = prazoEmprestimo;
	}
	public void setMultaAtraso(double multaAtraso) {
		MultaAtraso = multaAtraso;
	}
	public List<Empréstimo> getEmpréstimos() {
		return Empréstimos;
	}
	public void setEmpréstimos(List<Empréstimo> empréstimos) {
		Empréstimos = empréstimos;
	}
	@Override
	public void adicionar(Empréstimo emprestimo) { //implementação de métodos
		Empréstimos.add(emprestimo);
	}
	@Override
	public void remover(Empréstimo emprestimo) {
		Empréstimos.remove(emprestimo);
	}
	@Override
	public void consultar() {
		for(Empréstimo emprestimo : Empréstimos) {
			System.out.println("Item:" + emprestimo.getObjeto() + " Pedinte:" + emprestimo.getPedinte());
		}
	}	
}