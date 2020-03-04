
package mengde.tabell;

import java.util.Random;

import Iterator.Iterator;
import mengde.adt.MengdeADT;

public class TabellMengde <T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell

	private static Random tilf= new Random();
	private final static int STDK =  100;
	private int antall;
	private T[] tab;

	public TabellMengde(){
		this(STDK);

	}

	public TabellMengde(int start) {
		antall=0;
		tab= (T[])(new Object [start]);
	}




	/**********************************************
	Legger til elementet til denne mengden hvis den ikke
	allerede er med.
	 **********************************************/
	@Override
	public void leggTil(T element){ //2
		if(!inneholder(element)) {
			if(antall==tab.length){
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}


	/*******************************************************
	Returnerer sann hvis mengden inneholder det spesifiserte
	elementet, usann ellers
	 *****************************************************/
	@Override
	public boolean inneholder(T element){ //3
		int pos = -1;
		for(int i = 0; (i<antall)&&(pos==-1); i++){
			if(tab[i].equals(element))
				pos = i;
		}
		return(pos!=-1);
	}


	@Override
	public boolean erLik(MengdeADT<T> m) {//4
		boolean likeMengder=true;
		Iterator<T> teller = m.oppramser();

		if (this.antall()==m.antall()) {

			while (teller.hasNext() && likeMengder) {
				if (!inneholder(teller.next())) 
					likeMengder=false;	
			} 

		}else{
			likeMengder=false;				
		}

		return likeMengder;
	}


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
		T svar = null;
		if (antall>0){
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall-1];
			tab[antall-1] = null; //kan ha med, men ikke nødvendig
			antall--;
		}
		return svar;
	}

	/**********************************************
	Fjerner og returnerer spesifisert element fra denne
	mengden hvis det fins, ellers returneres nullreferanse
	 **********************************************/
	@Override
	public T fjern(T element) {//7
		int pos = -1;
		T svar= null;
		if (!erTom()) {
			for(int i = 0; (i<antall)&&(pos==-1); i++){
				if(tab[i].equals(element)){
					pos = i;
					svar=tab[pos];
					tab[pos]=tab[antall-1];
					antall--;
				}
			}

			
		}
		return(svar);
	}


	/**************************************************
	Returnerer en ny mengde som er unionen av denne mengden og
	parameteren
	 *********************************************************/
	@Override
	public MengdeADT<T> union(MengdeADT<T> m2){ // 8
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i<antall; i++){
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			begge.leggTil(teller.next());
		}
		return begge;
	}

	/**************************************************
	Returnerer en ny mengde som er unionen av denne mengden og
	parameteren
	 *********************************************************/
	public  MengdeADT<T> union_forbedret (MengdeADT<T> m2) { //8
		TabellMengde<T> begge = new TabellMengde<T>();
		T elem=null;

		//legger inn this "mengde"
		for (int i = 0; i<antall; i++){
			begge.settInn(tab[i]);
		}

		//legger in m2 "mengde"
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			elem=teller.next();
			if (!this.inneholder(elem)) 
				begge.settInn(elem);
		}
		return begge;
	}



	/** Returnerer en oppramser dvs en interfacereferanse som refererer til et objekt av
	TabellIterator */
	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	/** 
	 * */

	@Override
	public int antall(){
		return (antall);
	}

	/******************************************************************
	utvider tabellen med ekstra plass (tabell.length*1.1)+1)
	legg merke til at hvis tabellen har 9 plasser,vil ikke skjer noe i tilfelle (koe.length*1.1)
	 ******************************************************************/
	private void utvidKapasitet() {
		T[] hjelpeTabell = (T[])(new Object[(int) ((tab.length*1.1)+1)]);//10% +1 i tilfelle tabellen er mindre enn 10
		for (int indeks =0; indeks < tab.length; indeks++){
			hjelpeTabell[indeks] = tab[indeks];
		}
		tab = hjelpeTabell;
	}

	@Override
	public boolean erTom() {
		return (antall==0);
	}


	/**********************************************
	Legger til elementet til denne mengden uten å teste om den 	allerede er med.
	 **********************************************/

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}





	@Override
	public MengdeADT<T> differens (MengdeADT<T> m2){
		TabellMengde<T> differensM = new TabellMengde<T>();
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
		TabellMengde<T> snittM = new TabellMengde<T>();
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
