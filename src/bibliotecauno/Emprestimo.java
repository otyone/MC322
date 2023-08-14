package bibliotecauno;

public class Emprestimo {
	private int ISBN;
	private String Empr, DataReceb, DataEntrega;
	public Emprestimo( ) {
		ISBN = 0;
		Empr = DataReceb = DataEntrega = "Empty";
	}
	public Emprestimo (int m1, String n1, String n2, String n3) {
		ISBN = m1;
		Empr = n1;
		DataReceb = n2;
		DataEntrega = n3;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getEmpr() {
		return Empr;
	}
	public void setEmpr(String empr) {
		Empr = empr;
	}
	public String getDataReceb() {
		return DataReceb;
	}
	public void setDataReceb(String dataReceb) {
		DataReceb = dataReceb;
	}
	public String getDataEntrega() {
		return DataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		DataEntrega = dataEntrega;
	}
}
