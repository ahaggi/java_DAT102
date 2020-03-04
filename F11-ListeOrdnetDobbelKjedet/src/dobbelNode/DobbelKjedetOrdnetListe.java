package dobbelNode;
//********************************************************************
//  DobbeKjedetlOrdnetListeS.java       
//
//  Representerer en dobbeltkjedet ordnet liste med midtpeker.
//********************************************************************

import ADTen.DobbelKjedetOrdnetListeSADT;

public class DobbelKjedetOrdnetListe<T extends Comparable <T>> implements DobbelKjedetOrdnetListeSADT<T> {


	private DobbelNode<T> foerste;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;

	/******************************************************************
     Oppretter en tom liste.
	 ******************************************************************/
	//Konstrukt�r

	DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi){

		//F�rste node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;

		//Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;
		midten = siste;//OBS OBS!!

		antall = 0;
	}

	//***********************************************************************************
	// *
	// *
	// ***********************************************************************************

	@Override
	public void leggTil(T el){

		//Setter inn ordnet f�r den noden p peker p�
		DobbelNode<T> p;

		if((el.compareTo(foerste.getElement())<=0 )||(el.compareTo(siste.getElement())>=0)){
			//Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		}else{ // Kun lovlige verdier

			antall++;

			if(el.compareTo(midten.getElement()) >= 0){//Finn plass i siste halvdel
				p = midten.getNeste();
			}else{                                   // Finn plass i f�rste halvdel
				p = foerste.getNeste();
			}

			while(el.compareTo(p.getElement()) >= 0){
				p = p.getNeste();
			}//while

			// Setter inn:
			//Innsett foran noden som p peker p�

			DobbelNode<T> nyNode = new DobbelNode<T>(el);

			nyNode.setNeste(p);
			nyNode.setForrige(p.getForrige());
			p.getForrige().setNeste(nyNode);
			p.setForrige(nyNode);                             
			//Oppdaterer ny midten
			nyMidten(nyNode.getElement(),1);

		}//else lovlige

	}// 

	//**********************************************************************************
	// Hjelpemetode til � finne ny midten.
	// Mindre effektiv fordi vi m� gjennomg� ca halve listen, men greit nok,
	// ellers kan en teste p� om antall er partall er oddetall ved oppdatering av midtpeker
	//*********************************************************************************
	private void nyMidten(T el, int ndx){
		//OG i itlfellte el== midten.get element gj�r ingenting
		if (antall % 2 == 0) {
			if (el.compareTo(midten.getElement())>=0 && ndx>0) 
				midten=midten.getNeste();

			if (el.compareTo(midten.getElement())<=0 && ndx<0) 
				midten=midten.getNeste();	
		}else { //if (antall % 2 != 0)
		if (el.compareTo(midten.getElement())<0 && ndx>0) 
			midten=midten.getForrige();

		if (el.compareTo(midten.getElement())>=0 && ndx<0) 
			midten=midten.getForrige();	
	}
	//		int midtNR = antall/2 ;
	//		DobbelNode<T> p = foerste.getNeste();
	//		//kun "=" som gj�r midten =(antall/2)+1
	//		//slett "=" kan gj�re midten =(antall/2)
	//		for(int i = 1; i <= midtNR; i++){
	//			p = p.getNeste();
	//		}
	//		midten = p; 
}//


//***********************************************************************************
// *
// *
// ***********************************************************************************
@Override
public boolean fins(T el){
	boolean funnet = false;
	DobbelNode<T> p = null;
	if((el.compareTo(foerste.getElement())<=0 )||(el.compareTo(siste.getElement())>=0)){
		//Ugyldig. Alternativt kan vi ha det som et forkrav!
		System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());


	}else{ // Kun lovlige verdier    
		if(el.compareTo(midten.getElement()) >= 0){ //Let i siste halvdel
			p = midten;                          // Midten defineres � tilh�re siste del
		}else{                                   // Let i f�rste halvdel
			p = foerste.getNeste();
		}

		while(el.compareTo(p.getElement()) > 0){
			p = p.getNeste();
		}//while

		// Test p� funnet
		if(el.compareTo(p.getElement()) == 0){
			funnet = true;
		}
	}//else
	return funnet;
}//

//***********************************************************************************
// *
// *
// ***********************************************************************************

@Override
public T fjern(T el){
	T resultat = null;
	DobbelNode<T> p= null;
//	boolean funnet = false;

	if((el.compareTo(foerste.getElement())<=0) ||(el.compareTo(siste.getElement())>=0)){
		//Ugyldig. Alternativt kan vi ha det som et forkrav!
		System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

	}else{ // Kun lovlige verdier    

		//         if(el.compareTo(midten.getElement()) >= 0){
		//              p = midten;
		//          }
		//         else{
		//            p = foerste.getNeste();
		//          }
		//        
		//           while(el.compareTo(p.getElement()) > 0){
		//              p = p.getNeste();   
		//            }//while
		//          
		//            if(el.compareTo(p.getElement()) == 0){
		//                funnet = true;
		//             }
		p=finn(el);
		if(p!=null){  // (det er (boolean) finn)og ((node) fins)
			antall = antall -1;
			p.getForrige().setNeste(p.getNeste());
			p.getNeste().setForrige(p.getForrige());

			// Oppadtere midten
			nyMidten(p.getElement(),-1);         

			resultat = p.getElement();

		}//funnet

	}// lovlige
	return resultat;
}//  


/*  Alternativ  kan fjern-metoden bruke finn-metoden  */

private DobbelNode<T> finn(T el){
	DobbelNode<T> node = null;
	DobbelNode<T> p = null;           

	// Kun lovlige verdier    
	if(el.compareTo(midten.getElement()) >= 0){ //Let i siste halvdel
		p = midten;                            // Midten defineres � tilh�re siste del
	}
	else{                                    // Let i f�rste halvdel
		p = foerste.getNeste();
	}
	while(el.compareTo(p.getElement()) > 0){
		p = p.getNeste();
	}//while

	// Test p� funnet
	if(el.compareTo(p.getElement()) == 0){
		node = p;
	}
	return node;
}

//***********************************************************************************
// *
// *
// ***********************************************************************************

public void  skrivListe(){
	DobbelNode<T> p = foerste;

	while(p != null){
		System.out.print(p.getElement() + " ");
		p = p.getNeste();
	}

	System.out.println("Foerste:" + foerste.getElement() + " Midten:" + midten.getElement() + 
			" Siste:" + siste.getElement());
	System.out.println(); 

}//

}//class

