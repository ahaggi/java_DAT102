package kjede_koe;

import java.util.Random;

import Iterator.Iterator;
import adt_en.EmptyCollectionException;
import adt_en.KoeADT;

public class KjedetKoe<T> implements KoeADT<T>{
	private LinearNode<T> front, bak;
	private int antall;
	private static Random rand = new Random();

	/*******************************************************
Oppretter en tom kّ.
	 ********************************************************/
	public KjedetKoe() {
		front = bak = null;
		antall = 0;
	}

	/*******************************************************************
	Legger til det spesifiserte elementet i koen.
	Hvis koen er tom fra fّr, setter front og back pekere til nynode
	 *******************************************************************/
	@Override
	public void innKoe (T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		if (erTom()){
			front = nyNode;
		}
		else{
			bak.setNeste (nyNode);
		}
		bak = nyNode;
		antall++;
	}

	
	/*******************************************************************
	Fjerner toppelementet og returnerer en referanse til det.
	Hvis koen, retuneres null-referansen
	 *******************************************************************/
	@Override
	public T utKoe(){
		T resultat = null;
		if (erTom())
			throw new EmptyCollectionException("koe");

		if (!erTom()){ 
			resultat = front.getElement();
			front = front.getNeste();
			antall--;
		}

		return resultat;
	}

	/*******************************************************************
	Returnerer en referanse til det foerste elemenetet uten ه fjerne det.
	Hvis koen er tom fra fّr, sه returneres null-referansen
	 *******************************************************************/
	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("Koe");


		return  front.getElement();
	}

	/*******************************************************************
	Returnerer sann hvis kّen er tom og usann ellers.
	 *******************************************************************/
	@Override
	public boolean erTom() {
		return (antall==0);
	}
	/*************************************************************
	Returnerer antall elementer i koen.
	 *************************************************************/
	@Override
	public int antall() {
		return antall;
	}

	public boolean inneholder_v1 (T element){ //versjon 1
		boolean funnet = false;
		LinearNode<T> denne = front;
		for (int sّk = 0; sّk < antall && !funnet; sّk++){
			if (denne.getElement(). equals(element)){
				funnet = true;
			}
			else{
				denne = denne.getNeste();
			}
		}//end for
		return funnet;
	} 



	public boolean inneholder_v2 (T element){ //versjon 2
		boolean funnet = false;
		LinearNode<T> denne = front;
		while(denne != null && !funnet){
			if (denne.getElement(). equals(element)){
				funnet = true;
			}
			else{
				denne = denne.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean inneholder(T element) { //versjon 3
		LinearNode<T> denne = front;
		while (denne != null && ! element.equals(denne.getElement())) {
			denne = denne.getNeste();
		}
		return (denne != null);
	}

	public void leggTilForan(T element) {
		LinearNode<T> ny = new LinearNode<T>(element);
		ny.setNeste(front);
		front = ny;
		antall++;
	}

	/**************************************************
	Fjerner og returnerer et tilfeldig element fra denne
	mengden.
	 **************************************************/
	@Override
	public T fjernTilfeldig(){ //6
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()){
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = front.getElement();
				front = front.getNeste();
			}else {
				forgjenger = front;
				for (int nr=2; nr < valg; nr++){ // posisjoner
					forgjenger = forgjenger.getNeste();
				}//for

				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste()); // slett

				if (valg==antall) bak=forgjenger;

			}
			antall--;
		}//if
		return resultat;
	}

	@Override
	public T fjern(T element) {		
		LinearNode<T> denne;
		T resultat = null;
		if (!erTom()){
			if (front.getElement(). equals(element)) {
				resultat = front.getElement();
				front = front.getNeste();
				antall--;
			}else {
				denne = front;
				while(denne.getNeste()!= null && resultat==null){
					if (denne.getNeste().getElement().equals(element)){
						if (denne.getNeste()==bak) bak=denne;

						resultat=denne.getNeste().getElement();
						denne.setNeste(denne.getNeste().getNeste());
						antall--;
					}else{
						denne = denne.getNeste();
					}
				}//while
			}//else
		}//if er tom
		return resultat;
	}
//alternative fjern
//
//LinearNode<T> node= front;
//T el=null;
//boolean b=false;
//if (erTom()) {
//	throw new EmptyCollectionException("Koe");
//}
//if (element.equals(front.getElement())) {
//	b=true;
//	el=front.getElement();
//	front=(front.getNeste());
//	antall--;
//}else{
//	while (node.getNeste()!=null && !b) {
//		b=(element.equals(node.getNeste().getElement()));
//		if(!b)
//			node=node.getNeste();
//	}
//	if (b && el==null) {
//		el=node.getNeste().getElement();
//		node.setNeste(node.getNeste().getNeste());
//		antall--;
//	}
//}
//
//return el;		


	
	
	
	/** Returnerer en oppramser dvs en interfacereferanse som refererer til et objekt av kjedetIterator */
	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T> (front);
	}



	

	
	/**************************************************
	Returnerer en ny mengde som er unionen av denne mengden og
	parameteren
	 *********************************************************/
	@Override
	public  KoeADT<T> union (KoeADT<T> m2) { //8
		KjedetKoe<T> begge = new KjedetKoe<T>();
		LinearNode<T> denne = front;
		while (denne != null) {
			begge.innKoe (denne.getElement());
			denne = denne.getNeste();
		}//while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			begge.innKoe (teller.next());
		return begge;
	}


	@Override
	public KoeADT<T> differens (KoeADT<T> m2){
		KjedetKoe<T> differensM = new KjedetKoe<T>();
		T element;    
		Iterator<T> teller = this.oppramser();
		while (teller.hasNext()){
			element = teller.next();
			if(!m2.inneholder(element))
				differensM.innKoe(element);
		}
		return differensM;
	} 

	@Override
	public KoeADT<T> snitt (KoeADT<T> m2){
		KjedetKoe<T> snittM = new KjedetKoe<T>();
		T element;    
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			element = teller.next();
			if(this.inneholder(element))
				snittM.innKoe(element);
		}
		return snittM;
	} 

}