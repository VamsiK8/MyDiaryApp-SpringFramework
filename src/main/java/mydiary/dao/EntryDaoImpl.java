package mydiary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import mydiary.entities.Entry;

@Component
public class EntryDaoImpl implements EntryDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void save(Entry entry) {
		hibernateTemplate.save(entry);
	}

	@Transactional
	public void update(Entry entry) {
		hibernateTemplate.update(entry);
	}

	@Transactional
	public void delete(Entry entry) {
		hibernateTemplate.delete(entry);
	}

	@Override
	public Entry findByID(int id) {
		return hibernateTemplate.get(Entry.class, id);
	}

	@Override
	public List<Entry> findAll() {
		return hibernateTemplate.loadAll(Entry.class);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Entry> findEntriesByUserId(int id) {
		 DetachedCriteria criteria = DetachedCriteria.forClass(Entry.class); // Select * from Entry
		 criteria.add(Restrictions.eq("userid", id));
		 List<Entry> entries = (List<Entry>) hibernateTemplate.findByCriteria(criteria);
		return entries;
	}

}
