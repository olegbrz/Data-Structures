/*
 * Implementation of Doubly Linked List (DDL) on Java
 * 
 * Oleg Brezitskyy
 * Data Structures and Algorithms
 * 2º Ingeniería de la Salud
 * Universidad de Málaga
 * 
 */

package list;

// List interface defined by Dr. Carlos Cotta

public interface List<E> {

	// Elimina todos los elementos de la lista
	public void clear();
	
	// Inserta un elemento en la posición actual
	public boolean insert (E item);
	
	// Agrega un elemento al final de la lista
	public boolean append (E item);
	
	// Elimina (y devuelve) el elemento actual
	public E remove();
	
	// Mueve la posición actual al principio de la lista
	public void moveToStart();
	
	// Mueve la posición actual al final de la lista
	public void moveToEnd();
	
	// Mueve la posición actual a la anterior
	public void prev();
	
	// Mueve la posición actual a la siguiente
	public void next();
	
	// Devuelve la longitud de la lista
	public int length();
	
	// Devuelve el índice de la posición actual
	public int currPos();
	
	// Mueve la posición actual a la indicada
	public boolean moveToPos(int pos);
	
	// Devuelve el elemento actual
	public E getValue ();
	
	// Indica si la posición actual es la última
	public boolean isAtEnd ();
	
	// Indica si la lista está vacía o no
	public boolean isEmpty ();

}
