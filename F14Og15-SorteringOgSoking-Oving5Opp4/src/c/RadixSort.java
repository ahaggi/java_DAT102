package c;

import Iterator.Iterator;
import tabell_koe.TabellKoeSirkular;

public class RadixSort {// OBS! Her er for 4 sifrete tall, og med alle sifre
	// 0..9
	public static void main(String[] args) {
		int[] liste = { 123, 398, 210, 19, 528, 513, 129, 294 };
		String temp;
		Integer tallObj;
		int siffer, tall;

		// Sirkulærkoe er mer effektiv ved uttak
		TabellKoeSirkular<Integer>[] sifferKoer = new TabellKoeSirkular [10];


		/** sorterer liste */
		// Her er for 4 sifrete tall
		for (int posisjon = 0; posisjon <= 2; posisjon++) {// ytre løkke
			// Her bruker vi 10-tallet systemet. ved sortering av navn AZ trenger vi 26 køe
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++)
				sifferKoer[sifferVerdi] = new TabellKoeSirkular<Integer>(); // 9 køer inni i kø OBS

			for (int i = 0; i < liste.length; i++) {// indre løkke
				
				
				if (liste[i]<100 && liste[i]>=10) {
					temp ="0"+ String.valueOf(liste[i]); /** merk omgjøring til String */
				}else if (liste[i]<10 && liste[i]>=0) {
					temp ="00"+ String.valueOf(liste[i]); /** merk omgjøring til String */
				}else{
				temp = String.valueOf(liste[i]); /** merk omgjøring til String */
				}
				
				
				siffer = Character.digit(temp.charAt(2 - posisjon), 10);
				sifferKoer[siffer].innKoe(new Integer(liste[i]));
			} // indre løkke

			
			
			for (int i = 0; i < sifferKoer.length; i++) {
				System.out.print(i + ": ");
				Iterator<Integer> iterFelles = sifferKoer[i].oppramser();
				for (int j = 0; j < sifferKoer[i].antall(); j++) {
					System.out.print(iterFelles.next() + ", ");
				}
				System.out.println();
			}
			
			
			
			/* legger sorterte tall ut i liste */
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(sifferKoer[sifferVerdi].erTom())) {
					tallObj = sifferKoer[sifferVerdi].utKoe();
					liste[tall] = tallObj.intValue();
					tall++;
				} // while
			} // for
			
			for (int i = 0; i < liste.length; i++) {
				System.out.print(liste[i]+", ");
			}
			System.out.println();
			
		} // ytre løkke
		/** skriver ut sortert listet */
		for (int i = 0; i < liste.length; i++) {
			System.out.print(liste[i]+", ");
		}
	}// main
}// clas