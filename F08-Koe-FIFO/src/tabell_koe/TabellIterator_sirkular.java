package tabell_koe;

import Iterator.Iterator; 
public class TabellIterator_sirkular<T> implements Iterator<T>{
	// Klasse som har metoder som kan brukes til å gå gjennom
	// alle elementer i et objekt av klassen Mengde når denne klassen
	// Mengde er implementert vha tabell.

	private int antall; // antall elementer i mengden
	private int ndx; // den aktuelle posisjonen i iterasjonen
	private int front; // den aktuelle posisjonen i iterasjonen
	private T[] samling;

	public TabellIterator_sirkular(T[] tab, int lengde, int frnt){
		// Gi startverdier til iteratoren
		samling = tab;
		antall = lengde;
		front=frnt;
		ndx = 0;
	}

	@Override
	public boolean hasNext(){
		// Tester om det er flere elementer igjen
		return ((ndx+front)%samling.length < front+antall);
	}

	@Override
	public T next(){
		if(hasNext()){
			ndx++;
			return samling[(ndx+front-1)%samling.length];
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