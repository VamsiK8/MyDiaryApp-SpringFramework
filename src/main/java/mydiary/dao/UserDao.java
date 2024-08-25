package mydiary.dao;

import java.util.List;
import mydiary.entities.User;

public interface UserDao {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public User findByID(int id);
	public List<User> findAll(); 
	public User findByUsername(String username);
}
