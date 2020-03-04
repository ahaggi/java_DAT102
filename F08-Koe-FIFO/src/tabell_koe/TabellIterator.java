package tabell_koe;

import Iterator.Iterator;
public class TabellIterator<T> implements Iterator<T>{
	// Klasse som har metoder som kan brukes til å gå gjennom
	// alle elementer i et objekt av klassen Mengde når denne klassen
	// Mengde er implementert vha tabell.

	private int antall; // antall elementer i mengden
	private int ndx; // den aktuelle posisjonen i iterasjonen
	private T[] samling;

	public TabellIterator(T[] tab, int lengde){
		// Gi startverdier til iteratoren
		samling = tab;
		antall = lengde;
		ndx = 0;
	}

	@Override
	public boolean hasNext(){
		// Tester om det er flere elementer igjen
		return (ndx < antall);
	}

	@Override
	public T next(){
		if(hasNext()){
			ndx++;
			return samling[ndx-1];
		}else{
			return null;
		}
	}

	public void remove(){
//		samling[pos-1]=samling[antall-1];
//		samling[antall-1]=null;
//		antall--;
		
		System.out.println("Denne er ikke implementert");
	}
}//class