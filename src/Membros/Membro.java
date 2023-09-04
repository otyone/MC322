package Membros;

public class Membro {
	private String Nome, Endereço; //atributos básicos de todo membro
	private int Contato, NumID, Data;
	public Membro() { //construtor padrão
		Nome = Endereço = "Empty";
		Contato = NumID = Data = 0;
	}
	public Membro(String nome, String endereço, int contato, int numID, int data) { //construtor específico
		Nome = nome;
		Endereço = endereço;
		Contato = contato;
		NumID = numID;
		Data = data;
	}
	public String getNome() { //getters e setters
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereço() {
		return Endereço;
	}
	public void setEndereço(String endereço) {
		Endereço = endereço;
	}
	public int getContato() {
		return Contato;
	}
	public void setContato(int contato) {
		Contato = contato;
	}
	public int getNumID() {
		return NumID;
	}
	public void setNumID(int numID) {
		NumID = numID;
	}
	public int getData() {
		return Data;
	}
	public void setData(int data) {
		Data = data;
	}
	
}
