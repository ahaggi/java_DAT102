package adt_en;

import kjedet_stabel.KjedetStabel;
import tabell_stabell.TabellStabel;

public class KlientStabel{
	public static void main (String[] args){
		String str = ".rutkurtsatad OFIL ne re relbatS";
		System.out.println(str);
		System.out.println();

		
		// Snu tekst vha stabel
		int lengde = str.length();
		TabellStabel<Character> tegnStabel = new TabellStabel<Character>();
		
		//prøver å ta ut en element fra en tom liste 
		try {
			tegnStabel.pop();
		} catch ( EmptyCollectionException e) {
			System.out.println("pop failed unexpectedly, " + e.getMessage()+"\n");
		}
		
		for (int i = 0; i < lengde ;i++){
			tegnStabel.push(new Character(str.charAt(i)));
		}
		System.out.println("Ved bruk av tabell strukturert stabel");
		while(!tegnStabel.erTom()){
			Character tegn_obj = tegnStabel.pop();
			System.out.print(tegn_obj);
		}
		System.out.println("\n");
		
		//-----------Kjedet struktur--------------
		KjedetStabel<Character> tegnKoe2 = new KjedetStabel<Character>();
		String streng2 = ".rutkurtsatad OFIL ne re relbatS";
		int lengde2 = streng2.length();
		for(int i = 0; i < lengde2; i++){
			tegnKoe2.push(new Character(streng2.charAt(i)));
		}
		System.out.println("Ved bruk av kjede strukturert stabel");
		while(!tegnKoe2.erTom()){
			Character tegn_obj = tegnKoe2.pop();
			System.out.print(tegn_obj);
		}
	}//main
}//clas