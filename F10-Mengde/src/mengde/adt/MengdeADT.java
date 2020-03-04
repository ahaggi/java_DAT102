package mengde.adt;

import Iterator.Iterator;

public interface MengdeADT <T> {
	/* Interface MengdeADT viser metoder for en mengde med type for
	returverdi og nødvendige parametre med type.
	
	*Husk, hvis vi bruker objektreferanse når vi alle public-metodene i klassen. Hvis vi bruker 
	*interfacereferanse når vi kun de public-metodene spesifisert i interface’et. 
	*/

	// Interface som definerer alle operasjoner i en ADT
	// med navn MengdeADT (en datasamling, en høgnivå datastruktur)

	/** Leegger til elementet til denne mengden hvis den 
	 * ikke
	 * allerede er med 
	 * 
	 * @param element element av type T  som skal legges til  mengden hvis den ikke allerede er med*/
	void leggTil(T element);

	/** legger mengden m til denne mengden
	 * @param m en mengde som skal legges til*/
	void leggTilAlle(MengdeADT<T> m);

	/** Fjerner og rutunerer et tilfeldig element fra mengden
	 * @return T en tilfeldig element  som skal fjernes eller null*/
	T fjernTilfeldig();

	/** Fjerner og retunerer det gitte elementet fra mengden
	 * @param element element av type T  som skal fjernes
	 * @return Det fjernete elementet eller null*/
	T fjern( T element);

	/** Leger unionen av denne mengden og parameteren
	 * @param m en mengde som skal være i union med denne mengden
	 * @return Mengden  */
	MengdeADT <T> union(MengdeADT<T> m);

	/** Retunerer true dersom mengden innholder gitt element
	 * @param element element av type T  som skal soeks etter
	 * @return Boolean true hvis mengden innholder det gitte elementet
	 **/
	boolean inneholder(T element);
	
	/** Tester om mengden og parameteren innholder nøyaktig de samme elementene
	 * @param m en mengde som skal sammenlignes med mengden
	 * @return Boolean true hvis de er like 
	 * */
	boolean erLik(MengdeADT <T> m);
	
	/**Taster om mengden er tom (dvs har 0 element)
	 * @return Boolean true hvis den er tom*/
	boolean erTom();
	
	/** Finn antall element i mengden
	 * @return antall elementer
	 * */
	int antall();
	
	/** lager et oppramser-objekt
	 *@return Retunerer en iterator*/ 
	Iterator<T> oppramser();
	/**
	 * Snittet av to mengder m1 og m2 er mengden av de elementer som både fins i m1 og m2
	 * @param m2
	 * @return
	 */
	MengdeADT<T> snitt(MengdeADT<T> m2);
	/**
	 * Differansen av to mengder m1 og m2, (m1- m2) er mengden av de elementer i m1 som ikke fins i m
	 * @param m2
	 * @return
	 */

	MengdeADT<T> differens(MengdeADT<T> m2);

	
}
