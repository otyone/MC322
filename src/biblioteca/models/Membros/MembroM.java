package biblioteca.models.Membros;

import biblioteca.models.*;

public class MembroM implements Membro {
	private String Nome, Identificacao; //atributos básicos de todo membro
	private int Contato, Data, LimiteEmprestimo, PrazoEmprestimo;
	private double MultaAtraso;
	public MembroM() { //construtor padrão
		Nome = Identificacao = "Empty";
		Contato = LimiteEmprestimo = PrazoEmprestimo = Data = 0;
		MultaAtraso = 0;
	}
	public MembroM(String nome, String identificacao, int contato, int data, int limiteEmprestimo, int prazoEmprestimo,
			double multaAtraso) {
		Nome = nome;
		Identificacao = identificacao;
		Contato = contato;
		Data = data;
		LimiteEmprestimo = limiteEmprestimo;
		PrazoEmprestimo = prazoEmprestimo;
		MultaAtraso = multaAtraso;
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
	
}