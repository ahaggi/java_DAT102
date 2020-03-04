package tabell_stabell;

import adt_en.EmptyCollectionException;
import adt_en.StabelADT;

public class TabellStabel<T> implements StabelADT<T>{
private final static int STDK = 100;
private int antall; // indikerer neste plass
private T[] stabel;

/*******************************************************************
Oppretter en tom stabel.
*******************************************************************/
public TabellStabel() {
this(STDK);
}
/*******************************************************************
Oppretter en tom stabel med en spesifisert kapasitet.
*******************************************************************/
public TabellStabel(int startKapasitet) {
antall = 0;
stabel = (T[])(new Object[startKapasitet]);
}

/*******************************************************************
Legger til det spesifiserte elementet pه toppen av stabelen, utvider kapasiteten
til stabelen hvis nّdvendig.
*******************************************************************/
@Override
public void push (T element) {
if (antall() == stabel.length){
utvid();
}
stabel[antall] = element;
antall++;
}

/*******************************************************************
Fjerner toppelementet og returnerer en referanse til det.
Hvis stabelen er tom fra fّr, returneres null-referansen
*******************************************************************/
@Override
public T pop() throws EmptyCollectionException {
if (erTom())
throw new EmptyCollectionException("Stabel");
antall--;// top peker på en tom plass
T result = stabel[antall];
stabel[antall] = null; // Kan slّyfes
return result;
}

/*******************************************************************
Returnerer en referanse til toppelementet uten ه fjerne det.
Hvis stabelen er tom fra fّr, sه returneres null-referansen
*******************************************************************/
@Override
public T peek() throws EmptyCollectionException {
if (erTom())
throw new EmptyCollectionException("Stabel");
return stabel[antall-1];// top peker på en tom plass
}

/*******************************************************************
Returnerer sann hvis stabelen er tom og usann ellers.
*******************************************************************/
@Override
public boolean erTom() {
return (antall == 0);
}


/*************************************************************
Returnerer antall elementer.
**************************************************************
**/
@Override
public int antall() {
return antall;
}

/*************************************************************
Oppretter en ny tabell for ه lagre innholdet.
*************************************************************/
private void utvid() {
T[] hjelpeTabell = (T[])(new Object[stabel.length*2]);
for (int indeks =0; indeks < stabel.length; indeks++){
hjelpeTabell[indeks] = stabel[indeks];
}
stabel = hjelpeTabell;
}


}//class