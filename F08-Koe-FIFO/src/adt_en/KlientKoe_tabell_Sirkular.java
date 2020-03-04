package adt_en;
import easyIO.*;
import tabell_koe.TabellKoeSirkular;

public class KlientKoe_tabell_Sirkular {
	public static void main(String[] args){
		Out skjerm= new Out();
		String linje ="****************************************************";
 
		
		//-----------Tabell struktur--------------
		TabellKoeSirkular<Integer> tegnKoe3 = new TabellKoeSirkular<Integer>();
		try {
			tegnKoe3.fjernTilfeldig();
		} catch (Exception e) {
			System.out.println("\n\n"+linje+"\n" +e.getMessage()+"\n"+linje+"\n\n");
		}
		for (int i = 0; i < 5; i++) {
			tegnKoe3.innKoe(i);
		}
		
		for (int i = 0; i < 3; i++) {
			skjerm.out(tegnKoe3.fjernTilfeldig()+"",10,3);
			System.out.print(", ");
		}
		
		System.out.println();
		
		while (!tegnKoe3.erTom()) {
			skjerm.out(tegnKoe3.utKoe()+"",10,3);
			System.out.print(", ");

		}
		
//		TabellKoeSirkular<Character> tegnKoe4 = new TabellKoeSirkular<Character>();
//		String streng3 = "0123456789";
//		String streng4 = "876543210";
//		int lengde3 = streng3.length();
//		for (int l = 0; l < 3; l++) {
//
//
//
//			for(int i = 0; i < lengde3; i++){
//				tegnKoe3.innKoe(new Character(streng3.charAt(i)));
//			}
//
//			Iterator<Character> iterFelles=tegnKoe3.oppramser();
//			for (int i = 0; i < tegnKoe3.antall(); i++) {
//				skjerm.out(iterFelles.next(),10,3);
//				System.out.print(", ");
//				if ((i+1)%10==0) {
//					System.out.println();
//				}
//			}
//
//			while (!tegnKoe3.erTom()) {
//				skjerm.out(tegnKoe3.utKoe(),10,3);
//				System.out.print(", ");
//
//			}
//			System.out.println();
//		}
	}//main
}//class