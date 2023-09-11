
package biblioteca.models.SistemaBiblioteca;

public class Equipamentos {
	static class Informatica{
		private int qndPC, qtdTab, qtdProj, qtdOutros;
		public Informatica(int qndPC, int qtdTab, int qtdProj, int qtdOutros) {
			this.qndPC = qndPC;
			this.qtdTab = qtdTab;
			this.qtdProj = qtdProj;
			this.qtdOutros = qtdOutros;
		}
		public int getQndPC() {
			return qndPC;
		}
		public void setQndPC(int qndPC) {
			this.qndPC = qndPC;
		}
		public int getQtdTab() {
			return qtdTab;
		}
		public void setQtdTab(int qtdTab) {
			this.qtdTab = qtdTab;
		}
		public int getQtdProj() {
			return qtdProj;
		}
		public void setQtdProj(int qtdProj) {
			this.qtdProj = qtdProj;
		}
		public int getQtdOutros() {
			return qtdOutros;
		}
		public void setQtdOutros(int qtdOutros) {
			this.qtdOutros = qtdOutros;
		}
	}
	static class Audiovisual{
		private int qtdCam, qtdMic, qtdSom;
		public Audiovisual(int qtdCam, int qtdMic, int qtdSom) {
			this.qtdCam = qtdCam;
			this.qtdMic = qtdMic;
			this.qtdSom = qtdSom;
		}
		public int getQtdCam() {
			return qtdCam;
		}
		public void setQtdCam(int qtdCam) {
			this.qtdCam = qtdCam;
		}
		public int getQtdMic() {
			return qtdMic;
		}
		public void setQtdMic(int qtdMic) {
			this.qtdMic = qtdMic;
		}
		public int getQtdSom() {
			return qtdSom;
		}
		public void setQtdSom(int qtdSom) {
			this.qtdSom = qtdSom;
		}
	}
	static class Impressão{
		private int qtdImp, qtdScan, qtdCop;
		public Impressão(int qtdImp, int qtdScan, int qtdCop) {
			this.qtdImp = qtdImp;
			this.qtdScan = qtdScan;
			this.qtdCop = qtdCop;
		}
		public int getQtdImp() {
			return qtdImp;
		}
		public void setQtdImp(int qtdImp) {
			this.qtdImp = qtdImp;
		}
		public int getQtdScan() {
			return qtdScan;
		}
		public void setQtdScan(int qtdScan) {
			this.qtdScan = qtdScan;
		}
		public int getQtdCop() {
			return qtdCop;
		}
		public void setQtdCop(int qtdCop) {
			this.qtdCop = qtdCop;
		}
	}
}