package hashTable;

/* Class to represent every node of the hash table */

public class Node<K, V> {
	
	private K key;
	private V value;

	
	/* Constructor */
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/* Getters and setters */
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
}
