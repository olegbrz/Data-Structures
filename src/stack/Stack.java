package stack;

public interface Stack <E > {
	
	/** Reinicializa la pila */
	public void clear ();
	
	/** Pone un elemento en el tope de la pila */
	public boolean push ( E it );
	
	/** Elimina y devuelve el elemento en el tope */
	 public E pop ();
	 
	 /** Devuelve una copia del elemento en el tope */
	public E topValue ();
	
	/** Devuelve la longitud de la pila */
	public int length ();
	
	 /** Comprueba si no hay elementos en la pila */
	public boolean isEmpty ();
	
	}
