package br.com.clinica.controllers;

import br.com.clinica.dao.AgendaMedicaDAO;
import br.com.clinica.entity.AgendaMedica;

public class PgtoAgendaConsultaController implements PaymentController<AgendaMedica> {
	public String getTitle() {
		return "Pagamento (agendamento de consulta)";
	}
	
	public void paymentFinished(boolean status, AgendaMedica item) {
		if (status) {
			AgendaMedicaDAO.getInstance().persist(item);
		}
	}
}