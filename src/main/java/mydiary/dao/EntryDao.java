package mydiary.dao;

import java.util.List;

import mydiary.entities.Entry;

public interface EntryDao {
	public void save(Entry entry);
	public void update(Entry entry);
	public void delete(Entry entry);
	public Entry findByID(int id);
	public List<Entry> findAll();
	public List<Entry> findEntriesByUserId(int id);
}
