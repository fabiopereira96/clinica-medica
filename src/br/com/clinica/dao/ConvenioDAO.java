package br.com.clinica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.clinica.entity.Convenio;

public class ConvenioDAO {

	private static ConvenioDAO instance;
	protected EntityManager entityManager;

	public static ConvenioDAO getInstance() {
		if (instance == null) {
			instance = new ConvenioDAO();
		}

		return instance;
	}
	
	private ConvenioDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("clinica-medica-jpa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Convenio getById(final int id) {
		return entityManager.find(Convenio.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Convenio> findAll() {
		return entityManager.createQuery("FROM " + Convenio.class.getName()).getResultList();
	}

	public void persist(Convenio convenio) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(convenio);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Convenio convenio) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(convenio);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Convenio convenio) {
		try {
			entityManager.getTransaction().begin();
			convenio = entityManager.find(Convenio.class, convenio.getCodigo());
			entityManager.remove(convenio);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

}
