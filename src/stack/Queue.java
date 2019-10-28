package stack;

public interface Queue<E> {
	
	/** Reinicializa la cola */
	public void clear ();
	
	/** Pone un elemento al final de la cola */
	public void insert ( E it );
	
	/** Elimina y devuelve el elemento en el frente */
	public E extract ();
	
	/** Devuelve una copia del elemento en el frente */
	public E front ();
	
	/** Devuelve la longitud de la cola */
	public int length ();
	
	/** Comprueba si no hay elementos en la cola */
	public boolean isEmpty ();
	
}
