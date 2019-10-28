package hashTable;

public class CircularHT<K, V> implements HashTable<K, V> {
	
	public Node<K, V>[] table;
	private int size;
	private double maxLoad;
	
	public CircularHT(int size, double maxLoad) {
		table = (Node<K, V>[]) new Node[size];
		this.maxLoad = maxLoad;
		this.size = 0;
	}
	
	private double getLoad() {
		return size / table.length;
	}
	
	private int getHash(K key) {
		int hash = key.hashCode();
		return (hash & 0x7fffffff) % table.length;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	private void resize() {
		Node<K, V>[] auxTable = table; 
		table = (Node<K, V>[]) new Node[2 * auxTable.length];

		for (int i=0; i<size; i++) {
			Node<K, V> aux = auxTable[i];
			int index = getHash(aux.getKey());
			
			while (table[index] != null) {
				index = (index + 1) % table.length;
			}
		}
	}

	@Override
	public void insert(K key, V value) {
		int index = getHash(key);
		Node<K, V> node = table[index];
		
		while (node != null) {
			index = (index + 1) % table.length;
			node = table[index];
		}
		table[index] = new Node<K, V>(key, value);
		size++;
		
		if (size / table.length > maxLoad) {
			resize();
		}
	}


	@Override
	public V search(K key) {
		int index = getHash(key);
		Node<K, V> node = table[index];
		while(node != null && node.getKey() != key) {
			index = (index + 1) % table.length;
			node = table[index];
		}
		
		return node == null ? null : node.getValue();
	}

	@Override
	public void delete(K key) {
		int index = getHash(key);
		Node<K, V> node = table[index];
		
		while (node != null && !node.getKey().equals(key)) {
			index = (index + 1) % table.length;
			node = table[index];
		}
		
		if (node != null) {
			table[index] = null;
			index = (index + 1) % table.length;
			node = table[index];
			
			while (node != null) {
				table[index] = null;
				insert(node.getKey(), node.getValue());
				index = (index + 1) % table.length;
				node = table[index];
			}
			size--;
		}
	}

}
