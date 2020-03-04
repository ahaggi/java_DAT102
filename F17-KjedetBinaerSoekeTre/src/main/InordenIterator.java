package main;

import java.util.*;

/**
 * Klassen implementerer en InordenIterator
 *
 */

public class InordenIterator<T> implements Iterator<T> {
	private Stack<BinaerTreNode<T>> s = null;
	private BinaerTreNode<T> aktuell = null;

	/**
	 * Oppretter en InordenIterator<T>, gaar helt til venstre i bs-treet.
	 */
	public InordenIterator(BinaerTreNode<T> rot) {
		s = new Stack<BinaerTreNode<T>>();
		aktuell = gaaTilVenstre(rot);
	}

	// gå helt til venstre
	// stable på venstrebarn
	private BinaerTreNode<T> gaaTilVenstre(BinaerTreNode<T> p) {
		if (p == null)
			return null;
		while (p.getVenstre() != null) {
			s.push(p);
			p = p.getVenstre();
		}
		return p;
	}

	/**
	 * Returnerer sann hvis iterasjonen har flere elementer.
	 *
	 */
	@Override
	public boolean hasNext() {
		return (aktuell != null);
	}

	/**
	 * Returnerer det neste elementet i iterasjonen hvis det fins.
	 *
	 */
	@Override
	public T next() {
		T resultat = null;

		if (hasNext()) {
			resultat = aktuell.getElement();

			if (aktuell.getHoyre() != null) // har et høyre undertre
				// stable på node for venstre undertre
				aktuell = gaaTilVenstre(aktuell.getHoyre());
			else if (!s.isEmpty())
				// ingen høyre undertre
				aktuell = s.pop();
			else
				aktuell = null; // slutt på treet
		}
		return resultat;
	}

	@Override
	public void remove() {
		// Ikke implementert

	}

}//
