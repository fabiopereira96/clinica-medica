package br.com.clinica.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.clinica.entity.AgendaEquipamento;
import br.com.clinica.entity.Medico;

public class AgendaEquipamentoDAO {

	private static AgendaEquipamentoDAO instance;
	protected EntityManager entityManager;

	public static AgendaEquipamentoDAO getInstance() {
		if (instance == null) {
			instance = new AgendaEquipamentoDAO();
		}
		return instance;
	}

	private AgendaEquipamentoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica-medica-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<AgendaEquipamento> findAll() {
		return entityManager.createQuery("FROM " + AgendaEquipamento.class.getName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<AgendaEquipamento> getByDateAndMedico(final Date date, Medico medico) {
		return entityManager.createQuery("FROM " + AgendaEquipamento.class.getName() + " WHERE data_agendamento=" + date + "AND medico=" + medico.getCodigo()).getResultList();
	}
	
	public void persist(AgendaEquipamento agenda) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(agenda);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(AgendaEquipamento agenda) {
		try {
			entityManager.getTransaction().begin();
			agenda = entityManager.find(AgendaEquipamento.class, agenda.getDataAgendamento());
			entityManager.remove(agenda);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}