package mydiary.business;

import java.util.List;


import mydiary.entities.Entry;

public interface EntryBusiness {
	public void save(Entry entry);
	public void update(Entry entry);
	public void delete(Entry entry);
	public Entry findByID(int id);
	public List<Entry> findAll();
	public List<Entry> findEntriesByUserId(int id);
}
