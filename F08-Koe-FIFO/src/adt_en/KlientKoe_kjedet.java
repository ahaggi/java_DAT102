package adt_en;
import Iterator.Iterator;
import easyIO.*;
import kjede_koe.KjedetKoe;

public class KlientKoe_kjedet {
	public static void main(String[] args){
		Out skjerm= new Out();
		String linje ="****************************************************";
		String linje2 ="-----------------------------------------";



		//-----------Kjedet struktur--------------
		KjedetKoe<Character> tegnKoe3 = new KjedetKoe<Character>();
		KjedetKoe<Character> tegnKoe4 = new KjedetKoe<Character>();
		String streng3 = "0123456789";
		String streng4 = "876543210";
		int lengde3 = streng3.length();
		int lengde4 = streng4.length();
		for(int i = 0; i < lengde3; i++){
			tegnKoe3.innKoe(new Character(streng3.charAt(i)));
		}
		for(int i = 0; i < lengde4; i++){
			tegnKoe4.innKoe(new Character(streng4.charAt(i)));
		}

		// Lager unionen av de to Koene
		KjedetKoe<Character> begge = new KjedetKoe<Character>();
		begge = (KjedetKoe<Character>) tegnKoe3.union(tegnKoe4);//se polo pdf
		System.out.println("Utskrift av unionen av begge Koene"+"\n"+linje2);
		//skriver ut og fjerner alle elementer i Købegge
		int antall=begge.antall();
		for (int i = 1; i <= antall; i++) {
			skjerm.out(begge.utKoe(),10,3);
			System.out.print(", ");
			if (i%10==0) {
				System.out.println();
			}
		}

//		tester ut tom koe
		try {
			begge.utKoe();

		} catch (Exception e) {
			System.out.println("\n\n"+linje+"\n" +e.getMessage()+"\n"+linje+"\n\n");
		}
		
		
		// Lager snittet av de to Koene
		KjedetKoe<Character> KøFelles = new KjedetKoe<Character>();
		KøFelles = (KjedetKoe<Character>) tegnKoe3.snitt(tegnKoe4);
		System.out.println("\n"+"\n"+"Utskrift av snittet av begge Koene"+"\n"+linje2);
		//skriver ut alle elementer i Felles
		Iterator<Character> iterFelles=KøFelles.oppramser();
		for (int i = 0; i < KøFelles.antall(); i++) {
			skjerm.out(iterFelles.next(),10,3);
			System.out.print(", ");
			if ((i+1)%10==0) {
				System.out.println();
			}
		}


		// Lager differansen av de to Koene
		KjedetKoe<Character> diff = new KjedetKoe<Character>();
		diff = (KjedetKoe<Character>) tegnKoe3.differens(tegnKoe4);
		System.out.println("\n"+"\n"+"Utskrift av differansen av begge "+"\n"+linje2);
		//skriver ut alle elementer i KøDiff
		Iterator<Character> iterDiff=diff.oppramser();
		for (int i = 0; i < diff.antall(); i++) {
			skjerm.out(iterDiff.next(),10,3);
			System.out.print(", ");
			if ((i+1)%10==0) {
				System.out.println();
			}
		}

		System.out.println("\n\n"+"fjerner alle elementer fra koe3");
		while(!tegnKoe3.erTom()){
			tegnKoe3.fjernTilfeldig();
		}
		
		System.out.println("\n\n"+"skriver alle elementer som er i koe 3+4, etter at vi har fjernet alle elementer i koe3");
		while(!tegnKoe3.erTom()){
			Character tegn_obj = tegnKoe3.utKoe();
			System.out.print(tegn_obj);
		}

		while(!tegnKoe4.erTom()){
			Character tegn_obj = tegnKoe4.utKoe();
			System.out.print(tegn_obj);
		}

	}//main
}//class