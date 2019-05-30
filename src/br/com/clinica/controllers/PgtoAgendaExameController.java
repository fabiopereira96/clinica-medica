package br.com.clinica.controllers;

import br.com.clinica.dao.AgendaEquipamentoDAO;
import br.com.clinica.entity.AgendaEquipamento;

public class PgtoAgendaExameController implements PaymentController<AgendaEquipamento> {
	public String getTitle() {
		return "Pagamento (agendamento de exame)";
	}
	
	public void paymentFinished(boolean status, AgendaEquipamento item) {
		if (status) {
			AgendaEquipamentoDAO.getInstance().persist(item);
		}
	}
}
