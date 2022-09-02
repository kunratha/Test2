package bll;

import java.util.List;

import bo.PostIt;
import dal.PostItDAO;
import dal.PostItDAOHibernateImpl;

public class PostItBLL {
	private PostItDAO dao;
	
	public PostItBLL() {
		dao = new PostItDAOHibernateImpl();
	}
	
	public List<PostIt> selectAll() {
		return dao.selectAll();
	}
	
	public PostIt selectById(int id) {
		return dao.selectById(id);
	}

	public void insert(PostIt postit) throws Exception {
		if (postit.getDateModif() != null) {
			throw new Exception("Lors d'une creation, la date de modification devrait etre null");
		}
		dao.insert(postit);
	}

	public void update(PostIt postit) throws Exception {
		if (postit.getDateModif().isBefore(postit.getDateCrea())) {
			throw new Exception("La date de modification ne doit pas etre anterieure a la date de creation");
		}
		dao.update(postit);
	}

	public void delete(int id) {
		dao.delete(id);
	}
}
