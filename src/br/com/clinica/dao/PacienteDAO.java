package br.com.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.clinica.entity.Paciente;

public class PacienteDAO {

	private static PacienteDAO instance;
	protected EntityManager entityManager;

	public static PacienteDAO getInstance() {
		if (instance == null) {
			instance = new PacienteDAO();
		}

		return instance;
	}

	private PacienteDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica-medica-jpa");
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Paciente getById(final int id) {
		return entityManager.find(Paciente.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> findAll() {
		return entityManager.createQuery("FROM " + Paciente.class.getName()).getResultList();
	}

	public void persist(Paciente paciente) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(paciente);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Paciente paciente) {
		try {
			entityManager.getTransaction().begin();
			paciente = entityManager.find(Paciente.class, paciente.getCodigo());
			entityManager.remove(paciente);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
