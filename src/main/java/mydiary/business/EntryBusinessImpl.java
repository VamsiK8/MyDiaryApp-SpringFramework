package mydiary.business;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mydiary.dao.EntryDao;
import mydiary.entities.Entry;

@Component
public class EntryBusinessImpl implements EntryBusiness {
	
	@Autowired
	private EntryDao entryDao;

	@Override
	public void save(Entry entry) {
		entryDao.save(entry);
	}

	@Override
	public void update(Entry entry) {
		entryDao.update(entry);
	}

	@Override
	public void delete(Entry entry) {
		entryDao.delete(entry);
	}

	@Override
	public Entry findByID(int id) {
		return entryDao.findByID(id);
	}

	@Override
	public List<Entry> findAll() {
		return entryDao.findAll();
	}
	
	public EntryDao getEntryDao() {
		return entryDao;
	}

	public void setEntryDao(EntryDao entryDao) {
		this.entryDao = entryDao;
	}

	@Override
	public List<Entry> findEntriesByUserId(int id) {
		return entryDao.findEntriesByUserId(id);
	}



	
}
