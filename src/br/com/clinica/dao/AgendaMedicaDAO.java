package br.com.clinica.dao;

import br.com.clinica.entity.AgendaMedica;
import br.com.clinica.entity.Medico;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AgendaMedicaDAO {

	private static AgendaMedicaDAO instance;
	protected EntityManager entityManager;
	private final SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	public static AgendaMedicaDAO getInstance() {
		if (instance == null) {
			instance = new AgendaMedicaDAO();
		}
		return instance;
	}

	private AgendaMedicaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica-medica-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public AgendaMedica getByDate(final Date date) {
		return entityManager.find(AgendaMedica.class, date);
	}
	
	@SuppressWarnings("unchecked")
	public List<AgendaMedica> getByMedico(Medico medico) {
		return entityManager.createQuery("FROM " + AgendaMedica.class.getName() + " WHERE medico=" + medico.getCodigo()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<AgendaMedica> isConflict(final Date date, Medico doctor) {
		String strDate = this.sdf.format(date);

		return entityManager.createQuery(
			"FROM " + AgendaMedica.class.getName() + " WHERE dia_agendamento <= " + strDate + " AND " + strDate + " <= ADDTIME(dia_agendamento, " + doctor.getIntervaloAtendimento() + ":00) AND medico=" + doctor.getCodigo()
		).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<AgendaMedica> findAll() {
		return entityManager.createQuery("FROM " + AgendaMedica.class.getName()).getResultList();
	}

	public void persist(AgendaMedica agenda) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(agenda);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(AgendaMedica agenda) {
		try {
			entityManager.getTransaction().begin();
			agenda = entityManager.find(AgendaMedica.class, agenda.getDiaAgendamento());
			entityManager.remove(agenda);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
