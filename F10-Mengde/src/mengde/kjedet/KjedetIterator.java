
package mengde.kjedet;
import Iterator.Iterator;

//********************************************************
// Representerer en iterator for en kjedet struktur av noder
// kjedet lineært.
//*********************************************************
public class KjedetIterator<T> implements Iterator<T> {

	private LinearNode<T> aktuell; // den aktuelle referansen i
	// iterasjonen
	
	
	
	/*********************************************************
	 * Lager en iterator (oppramser)
	 **********************************************************/
	public KjedetIterator (LinearNode<T> start) {
		aktuell = start;
	}

	
	/**********************************************************
	 * Returnerer sann hvis iteratoren har minst ett element igjen.
	 **********************************************************/
	@Override
	public boolean hasNext() {
		return (aktuell!= null);
	}
	
	
	/**********************************************************
	 * Returnerer neste element hvis det fins
	 **********************************************************/
	@Override
	public T next() {
		T resultat = null;
		if (hasNext()){
			resultat = aktuell.getElement();
			aktuell = aktuell.getNeste();
		}
		return resultat;
	}
	
}