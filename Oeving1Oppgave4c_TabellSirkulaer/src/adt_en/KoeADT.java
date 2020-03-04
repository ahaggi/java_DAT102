package adt_en;

public interface KoeADT<T>{ //Bruk javadoc i stedet for kommentarer som her
// Bruke @Override f�r metodene i implementasjonsfil
/** Legge til et element bak i k�en. */
void innKoe (T element);
/** Fjerner og returnerer elementet foran i k�en.*/
T utKoe();
/** Returnerer elementet foran i k�en uten � fjerne det fra k�en. */
T foerste();
/** Returns sann hvis denne k�ene ikke inneholder noen elementer.. */
boolean erTom();
/** Returnerer antall elementer i k�en. */
int antall();
}//