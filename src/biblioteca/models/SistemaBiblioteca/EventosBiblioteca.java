package biblioteca.models.SistemaBiblioteca;

import biblioteca.models.*;

import java.util.List;
import java.util.LinkedList;

public class EventosBiblioteca {
	static class Exposição{
		private String Tema, Local, Expositores;
		private int duração;
		List<Membro> membros = new LinkedList<>();
		public Exposição(String tema, String local, String expositores, int duração, List<Membro> membros) {
			Tema = tema;
			Local = local;
			Expositores = expositores;
			this.duração = duração;
			this.membros = membros;
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
		public List<Membro> getMembros() {
			return membros;
		}
		public void setMembros(List<Membro> membros) {
			this.membros = membros;
		}
		public void adicionar(Membro membro) {
			membros.add(membro);
		}
		public void remover(Membro membro) {
			membros.remove(membro);
		}
	}
	static class Workshop{
		private String Instrutor, Tópico, Local;
		private int data, horário;
		private EquipamentosMultimidia Equips;
		List<Membro> membros = new LinkedList<>();
		public Workshop(String instrutor, String tópico, String local, int data, int horário,
				EquipamentosMultimidia equips, List<Membro> membros) {
			Instrutor = instrutor;
			Tópico = tópico;
			Local = local;
			this.data = data;
			this.horário = horário;
			Equips = equips;
			this.membros = membros;
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
		public List<Membro> getMembros() {
			return membros;
		}
		public void setMembros(List<Membro> membros) {
			this.membros = membros;
		}
		public void adicionar(Membro membro) {
			membros.add(membro);
		}
		public void remover(Membro membro) {
			membros.remove(membro);
		}
	}
	static class Palestra{
		private String Palestrante, Tópico, Local;
		private int data, horário;
		List<Membro> membros = new LinkedList<>();
		public Palestra(String palestrante, String tópico, String local, int data, int horário, List<Membro> membros) {
			Palestrante = palestrante;
			Tópico = tópico;
			Local = local;
			this.data = data;
			this.horário = horário;
			this.membros = membros;
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
		public List<Membro> getMembros() {
			return membros;
		}
		public void setMembros(List<Membro> membros) {
			this.membros = membros;
		}
		public void adicionar(Membro membro) {
			membros.add(membro);
		}
		public void remover(Membro membro) {
			membros.remove(membro);
		}
	}
}