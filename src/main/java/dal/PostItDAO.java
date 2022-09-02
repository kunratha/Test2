package dal;

import java.util.List;

import bo.PostIt;

public interface PostItDAO {
	public List<PostIt> selectAll();
	public PostIt selectById(int id);
	public void insert(PostIt postit);
	public void update(PostIt postit);
	public void delete(int id);
}
