package biblioteca.views;

import biblioteca.controllers.RelatorioController;

public class RelatorioViewImpl implements RelatorioView{
	private RelatorioController relatorioController;

	public RelatorioViewImpl(RelatorioController relatorioController) {
		this.relatorioController = relatorioController;
	}

	public RelatorioController getRelatorioController() {
		return relatorioController;
	}

	public void setRelatorioController(RelatorioController relatorioController) {
		this.relatorioController = relatorioController;
	}
	
}