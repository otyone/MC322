package LSP;

public abstract class Dispositivo {
	private Integer tamanho;

	public Dispositivo(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
	
	public abstract String getFuncao();
}