package bibliotecauno;

public class Funcionario {
	private String Nome, Area, Cargo;
	public Funcionario() {
		Nome = Area = Cargo = "Empty";
	}
	public Funcionario(String n1, String n2, String n3) {
		Nome = n1;
		Area = n2;
		Cargo = n3;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
}
