package mengde.kjedet;

import java.util.Random;

import Iterator.Iterator;
import mengde.adt.MengdeADT;

public class KjedetMengde <T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; //antall elementer i mengden
	private LinearNode <T> start;

	/********************************************************
	 * Oppretter en tom mengdeّ.
	 ********************************************************/
	public KjedetMengde() {
		start = null;
		antall = 0;
	}

	/**********************************************
	 * Legger til elementet til denne mengden hvis den ikke allerede er med.
	 **********************************************/
	@Override
	public void leggTil(T element){ //2
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T> (element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	/*******************************************************
	Returnerer sann hvis mengden inneholder det spesifiserte
	elementet, usann ellers
	 *****************************************************/
	@Override
	public boolean inneholder(T element){ //3
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int søk =0; søk < antall && !funnet; søk++){
			if (aktuell.getElement().equals(element)){
				funnet = true;
			}
			else{
				aktuell = aktuell.getNeste();
			}
		}//for
		return funnet;
	}

	/** Returnerer sann hvis de to mengdene er like, eller usann*/
	@Override
	public boolean erLik(MengdeADT<T> m) {//4
		boolean likeMengder=true;
		Iterator<T> teller = m.oppramser();

		if (antall()==m.antall()) {

			while (teller.hasNext() && likeMengder) {
				if (!inneholder(teller.next())) 
					likeMengder=false;	
			} 

		}else{
			likeMengder=false;				
		}

		return likeMengder;
	}

	//	@Override
	//	public boolean erLik(MengdeADT<T> m2) {
	//		boolean likeMengder = true;
	//		T element = null;
	//		if (antall() == m2.antall()) {
	//		
	//			Iterator<T> teller = m2.oppramser();
	//			
	//			while (teller.hasNext() && likeMengder) {
	//				element = teller.next();
	//				if (!this.inneholder(element)) {
	//					likeMengder = false;
	//				}// if
	//				
	//			}// while
	//		}// if
	//		else {
	//			likeMengder = false;
	//		}
	//		return likeMengder;
	//	}



	/*****************************************
	Legger mengden m2 til denne mengden
	 *********************************************/
	@Override
	public void leggTilAlle(MengdeADT<T> m2){ //5
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
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
				resultat = start.getElement();
				start = start.getNeste();
			}else {
				forgjenger = start;
				for (int nr=2; nr < valg; nr++){ // posisjoner
					forgjenger = forgjenger.getNeste();
				}//for
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste()); // slett
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
			if (start.getElement(). equals(element)) {
				resultat = start.getElement();
				start = start.getNeste();
				antall--;
			}else {
				denne = start;
				while(denne.getNeste()!= null && resultat==null){
					if (denne.getNeste().getElement().equals(element)){
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


	/**************************************************
	Returnerer en ny mengde som er unionen av denne mengden og
	parameteren
	 *********************************************************/
	@Override
	public  MengdeADT<T> union (MengdeADT<T> m2) { //8
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> denne = start;
		while (denne != null) {
			begge.leggTil (denne.getElement());
			denne = denne.getNeste();
		}//while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			begge.leggTil (teller.next());
		return begge;
	}
	
	/**************************************************
	Returnerer en ny mengde som er unionen av denne mengden og
	parameteren
	 *********************************************************/
	public  MengdeADT<T> union_forbedret (MengdeADT<T> m2) { //8
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> denne = start;
		T elem=null;

		while (denne != null) {
			begge.settInn(denne.getElement());
			denne = denne.getNeste();
		}//while

		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			elem=teller.next();
			if (!this.inneholder(elem)) 
				begge.settInn (elem);
		}
		return begge;
	}



	@Override
	public boolean erTom() {
		return (antall()==0);
	}

	/** Returnerer en oppramser dvs en interfacereferanse som refererer til et objekt av kjedetIterator */
	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T> (start);
	}
	@Override
	public int antall(){
		return (antall);
	}


	/**********************************************
	Legger til elementet til denne mengden uten å teste om den allerede er med.
	 **********************************************/

	private void settInn(T element){
		LinearNode<T>nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode; 
		antall++;
	}

	@Override
	public MengdeADT<T> differens (MengdeADT<T> m2){
		KjedetMengde<T> differensM = new KjedetMengde<T>();
		T element;    
		Iterator<T> teller = this.oppramser();
		while (teller.hasNext()){
			element = teller.next();
			if(!m2.inneholder(element))
				differensM.settInn(element);
		}
		return differensM;
	} 

	@Override
	public MengdeADT<T> snitt (MengdeADT<T> m2){
		KjedetMengde<T> snittM = new KjedetMengde<T>();
		T element;    
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			element = teller.next();
			if(this.inneholder(element))
				snittM.settInn(element);
		}
		return snittM;
	} 










}
