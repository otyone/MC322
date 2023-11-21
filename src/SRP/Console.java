package SRP;

public class Console implements Mostrar {

	@Override
	public void display(String texto1, String texto2, String texto3) {
		System.out.println("Nome do Item: " +texto1 +"\n" + "Informação 2: " +texto2 +"\n" + "Informação 3: " +texto3 +"\n");
	}
}