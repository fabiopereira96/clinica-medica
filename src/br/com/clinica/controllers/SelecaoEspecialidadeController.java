package br.com.clinica.controllers;

import java.util.List;

import br.com.clinica.SelecaoWindow;
import br.com.clinica.dao.EspecialidadeDAO;
import br.com.clinica.entity.Especialidade;
import br.com.clinica.entity.Medico;

public class SelecaoEspecialidadeController implements SelectionController<Especialidade> {
	public String getTitle() {
		return "Agendamento de consulta (especialidade)";
	}
	
	public String getLabel() {
		return "Selecione a especialidade";
	}
	
	public String getBtnText() {
		return "Selecionar";
	}
	
	public List<Especialidade> getElements() {
		return EspecialidadeDAO.getInstance().findAll();
	}

	@SuppressWarnings("rawtypes")
	public void selectedElement(Especialidade spec) {
		SelecaoWindow selecaoMedicoWindow
			= new SelecaoWindow<Medico, SelecaoMedicoController>(
				new SelecaoMedicoController(spec)
			  );

		selecaoMedicoWindow.showFrame();
	}
}