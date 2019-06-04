package br.com.clinica.controllers;

import java.util.List;

import br.com.clinica.EdicaoAgendaExameWindow;
import br.com.clinica.dao.AgendaEquipamentoDAO;

import br.com.clinica.entity.AgendaEquipamento;

public class SelecaoAgendaExameController implements SelectionController<AgendaEquipamento> {
	public String getTitle() {
		return "Atualização de agenda (selecione o exame)";
	}
	
	public String getLabel() {
		return "Selecione o exame";
	}
	
	public String getBtnText() {
		return "Editar";
	}
	
	public List<AgendaEquipamento> getElements() {
		return AgendaEquipamentoDAO.getInstance().findAll();
	}

	public void selectedElement(AgendaEquipamento agenda) {
		EdicaoAgendaExameWindow edicaoAgendaExameWindow = new EdicaoAgendaExameWindow(agenda);
		edicaoAgendaExameWindow.showFrame();
	}
}