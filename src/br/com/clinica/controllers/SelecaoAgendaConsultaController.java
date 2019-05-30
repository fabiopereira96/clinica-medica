package br.com.clinica.controllers;

import java.util.List;

import br.com.clinica.EdicaoAgendaConsultaWindow;
import br.com.clinica.dao.AgendaMedicaDAO;

import br.com.clinica.entity.AgendaMedica;

public class SelecaoAgendaConsultaController implements SelectionController<AgendaMedica> {
	public String getTitle() {
		return "Atualização de agenda (selecione a consulta)";
	}
	
	public String getLabel() {
		return "Selecione a consulta";
	}
	
	public String getBtnText() {
		return "Editar";
	}
	
	public List<AgendaMedica> getElements() {
		return AgendaMedicaDAO.getInstance().findAll();
	}

	public void selectedElement(AgendaMedica agenda) {
		EdicaoAgendaConsultaWindow edicaoAgendaConsultaWindow = new EdicaoAgendaConsultaWindow(agenda);
		edicaoAgendaConsultaWindow.showFrame();
	}
}
