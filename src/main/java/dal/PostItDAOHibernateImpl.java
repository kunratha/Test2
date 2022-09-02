package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.PostIt;

public class PostItDAOHibernateImpl implements PostItDAO {
	private EntityManagerFactory emf;
	
	public PostItDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("user");
	}
	
	@Override
	public List<PostIt> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<PostIt> resultat = em.createQuery("from PostIt", PostIt.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public PostIt selectById(int id) {
		EntityManager em = emf.createEntityManager();
		PostIt resultat = em.find(PostIt.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void insert(PostIt postit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(postit);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public void update(PostIt postit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(postit);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public void delete(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em
				.createQuery("DELETE FROM PostIt WHERE id = :id")
				.setParameter("id", id)
				.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}
}
