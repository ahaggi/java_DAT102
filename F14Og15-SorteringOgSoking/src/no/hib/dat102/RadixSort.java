package no.hib.dat102;

import tabell_koe.TabellKoeSirkular;

public class RadixSort{// OBS! Her er for 4 sifrete tall, og med alle sifre 0..9
	public static void main ( String[] args){
		int[] liste = {7843, 4568, 8765, 6543, 7865, 4532,9987, 3241, 6589, 6622, 1211};
		String temp;
		Integer tallObj;
		int siffer, tall;

		//Sirkul�rkoe er mer effektiv ved uttak
		TabellKoeSirkular<Integer>[] sifferKoer =	new TabellKoeSirkular[10]; // tabell av koeer

		//Her bruker vi 10-tallet systemet. ved sortering av navn A�Z trenger vi 26 k�e
		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++)
			sifferKoer[sifferVerdi] = new TabellKoeSirkular<Integer>(); // 9 k�er inni i tabell OBS

		/** sorterer liste */
//		Her er for 4 sifrete tall
		for (int posisjon=0; posisjon <= 3; posisjon++){//ytre l�kke
			for (int i =0; i < liste.length; i++){//indre l�kke
				temp = String.valueOf(liste[i]); /** merk omgj�ring til String */
				siffer = Character.digit (temp.charAt(3-posisjon), 10);
				sifferKoer[siffer].innKoe (new Integer(liste[i]));
			}//indre l�kke

			/* legger sorterte tall ut i liste */
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++){
				while (!(sifferKoer[sifferVerdi].erTom())){
					tallObj = sifferKoer[sifferVerdi].utKoe();
					liste[tall] = tallObj.intValue();
					tall++;
				}//while
			}//for
		}//ytre l�kke
		/** skriver ut sortert listet */
		for (int i=0; i < liste.length; i++){
			System.out.println (liste[i]);
		}
	}//main
}//clas