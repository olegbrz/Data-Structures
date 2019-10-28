package hashTable;

public interface HashTable<K, V> {
	
	/** Test for table emptiness . */
	public boolean isEmpty();
	
	/** Retrieves number of key/ value associations .*/
	public int size();
	
	/** Inserts a new key/ value association in table . */
	public void insert(K k, V v);
	
	/** Retrieves value associated to key. */
	public V search(K k);
	
	/** Removes a key/ value association from table . */
	public void delete(K k);


}
