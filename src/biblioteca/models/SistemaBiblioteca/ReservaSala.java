package biblioteca.models.SistemaBiblioteca;

public class ReservaSala {
	private int dataReserva, horaInicio, horaFim;
	public ReservaSala(int dataReserva, int horaInicio, int horaFim) {
		this.dataReserva = dataReserva;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	static class SalaIndividual{
		private int numero;
		boolean disponivel;
		public SalaIndividual(int numero, boolean disponivel) {
			this.numero = numero;
			this.disponivel = disponivel;
		}
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
		public boolean isDisponivel() {
			return disponivel;
		}
		public void setDisponivel(boolean disponivel) {
			this.disponivel = disponivel;
		}
		
	}
	static class SalaGrupo{
		private int capacidade;
		boolean equipamento;
		public SalaGrupo(int capacidade, boolean equipamento) {
			this.capacidade = capacidade;
			this.equipamento = equipamento;
		}
		public int getCapacidade() {
			return capacidade;
		}
		public void setCapacidade(int capacidade) {
			this.capacidade = capacidade;
		}
		public boolean isEquipamento() {
			return equipamento;
		}
		public void setEquipamento(boolean equipamento) {
			this.equipamento = equipamento;
		}
		
	}
	static class SalaSilenciosa{
		private int assentos;
		boolean cabines;
		public SalaSilenciosa(int assentos, boolean cabines) {
			this.assentos = assentos;
			this.cabines = cabines;
		}
		public int getAssentos() {
			return assentos;
		}
		public void setAssentos(int assentos) {
			this.assentos = assentos;
		}
		public boolean isCabines() {
			return cabines;
		}
		public void setCabines(boolean cabines) {
			this.cabines = cabines;
		}
		
	}
	static class SalaMultimidia{
		private EquipamentosMultimidia Equips;
		public SalaMultimidia(EquipamentosMultimidia equips) {
			Equips = equips;
		}
		public EquipamentosMultimidia getEquips() {
			return Equips;
		}
		public void setEquips(EquipamentosMultimidia equips) {
			Equips = equips;
		}
	}
	public int getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(int dataReserva) {
		this.dataReserva = dataReserva;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}
}