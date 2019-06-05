package br.com.clinica.controllers;

import java.util.List;

import br.com.clinica.AgendamentoConsultaWindow;
import br.com.clinica.dao.MedicoDAO;
import br.com.clinica.entity.Especialidade;
import br.com.clinica.entity.Medico;

public class SelecaoMedicoController implements SelectionController<Medico> {
	private Especialidade espec;
	
	public SelecaoMedicoController(Especialidade espec) {
		this.espec = espec;
	}
	
	public String getTitle() {
		return "Agendamento de consulta (médico)";
	}
	
	public String getLabel() {
		return "Selecione o médico";
	}
	
	public String getBtnText() {
		return "Selecionar";
	}
	
	public List<Medico> getElements() {
		return MedicoDAO.getInstance().getByEspecialidade(espec.getCodigo());
	}

	public void selectedElement(Medico m) {
		AgendamentoConsultaWindow agendamentoConsultaWindow
			= new AgendamentoConsultaWindow(m.getCodigo());

		agendamentoConsultaWindow.showFrame();
	}
}