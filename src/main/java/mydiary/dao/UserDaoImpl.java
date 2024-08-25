package mydiary.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import mydiary.entities.User;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	@Transactional
	public void save(User user) {
		hibernateTemplate.save(user);
		
	}

	@Transactional
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	@Transactional
	public void delete(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	public User findByID(int id) {
		User user = hibernateTemplate.get(User.class, id );
		return user;
	}

	@Override
	public List<User> findAll() {
		return hibernateTemplate.loadAll(User.class);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));// where username="username"
		
		User user = null;  // to not .get(0) from null list
		
		 try { // handle .get(0) from null list
			user = (User) hibernateTemplate.findByCriteria(criteria).get(0); //it gives list but it contains only 1user as unique mentioned in db table so, get(0)
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return user;
		
	}

}
