package adt_en;

public interface KoeADT<T>{ //Bruk javadoc i stedet for kommentarer som her
// Bruke @Override før metodene i implementasjonsfil
/** Legge til et element bak i køen. */
void innKoe (T element);
/** Fjerner og returnerer elementet foran i køen.*/
T utKoe();
/** Returnerer elementet foran i køen uten å fjerne det fra køen. */
T foerste();
/** Returns sann hvis denne køene ikke inneholder noen elementer.. */
boolean erTom();
/** Returnerer antall elementer i køen. */
int antall();
}//