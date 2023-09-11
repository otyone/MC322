package biblioteca.models.SistemaBiblioteca;

public class EventosBiblioteca {
	static class Exposição{
		private String Tema, Local, Expositores;
		private int duração;
		public Exposição(String tema, String local, String expositores, int duração) {
			Tema = tema;
			Local = local;
			Expositores = expositores;
			this.duração = duração;
		}
		public String getTema() {
			return Tema;
		}
		public void setTema(String tema) {
			Tema = tema;
		}
		public String getLocal() {
			return Local;
		}
		public void setLocal(String local) {
			Local = local;
		}
		public String getExpositores() {
			return Expositores;
		}
		public void setExpositores(String expositores) {
			Expositores = expositores;
		}
		public int getDuração() {
			return duração;
		}
		public void setDuração(int duração) {
			this.duração = duração;
		}
	}
	static class Workshop{
		private String Instrutor, Tópico, Local;
		private int data, horário;
		private EquipamentosMultimidia Equips;
		public Workshop(String instrutor, String tópico, String local, int data, int horário,
				EquipamentosMultimidia equips) {
			Instrutor = instrutor;
			Tópico = tópico;
			Local = local;
			this.data = data;
			this.horário = horário;
			Equips = equips;
		}
		public String getInstrutor() {
			return Instrutor;
		}
		public void setInstrutor(String instrutor) {
			Instrutor = instrutor;
		}
		public String getTópico() {
			return Tópico;
		}
		public void setTópico(String tópico) {
			Tópico = tópico;
		}
		public String getLocal() {
			return Local;
		}
		public void setLocal(String local) {
			Local = local;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public int getHorário() {
			return horário;
		}
		public void setHorário(int horário) {
			this.horário = horário;
		}
		public EquipamentosMultimidia getEquips() {
			return Equips;
		}
		public void setEquips(EquipamentosMultimidia equips) {
			Equips = equips;
		}
	}
	static class Palestra{
		private String Palestrante, Tópico, Local;
		private int data, horário;
		public Palestra(String palestrante, String tópico, String local, int data, int horário) {
			Palestrante = palestrante;
			Tópico = tópico;
			Local = local;
			this.data = data;
			this.horário = horário;
		}
		public String getPalestrante() {
			return Palestrante;
		}
		public void setPalestrante(String palestrante) {
			Palestrante = palestrante;
		}
		public String getTópico() {
			return Tópico;
		}
		public void setTópico(String tópico) {
			Tópico = tópico;
		}
		public String getLocal() {
			return Local;
		}
		public void setLocal(String local) {
			Local = local;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public int getHorário() {
			return horário;
		}
		public void setHorário(int horário) {
			this.horário = horário;
		}
	}
}