package DIP;
import LSP.*;

public class Principal {
	private Dispositivo dispositivo;

	public Principal(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	public void Demo() {
		System.out.println("Dispositivo Principal de tamanho: " +dispositivo.getTamanho());
	}
	
}