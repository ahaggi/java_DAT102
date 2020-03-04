package Bingokule;

import Iterator.Iterator;
import mengde.kjedet.KjedetMengde;
public class KlientBingo{ 
	// Oppretter 2 mengder med 75 bingokuler i hver.
	// Tester om en spesiell bingokule er med i den ene mengden,
	// og om de to mengdene er nøyaktig like. 

	public static void main(String[] a){
		final int ANTALL_BALLER=75;
		KjedetMengde <Bingokule>minMengde1 = new KjedetMengde<Bingokule>();
		KjedetMengde <Bingokule>minMengde2 = new KjedetMengde<Bingokule>();
		Bingokule kule1  = null;
		Bingokule kule2  = null;
		Bingokule kule3  = null;
		Bingokule kule4  = null;
		Bingokule kule5  = null;

		//        for(int i=1; i <= ANTALL_BALLER; i++){
		//         kule1 = new Bingokule(i);
		//         kule2 = new Bingokule(ANTALL_BALLER+1-i);
		//             minMengde1.leggTil(kule1);
		//             minMengde2.leggTil(kule2);
		//        }
		//
		//        System.out.println("\nAntall kuler totalt: " + minMengde1.antall());
		//        System.out.println();
		//
		//        kule1 = new Bingokule(10);
		//        if(minMengde1.inneholder(kule1))
		//            System.out.println("kule 1 funnet i mengde 1");
		//          
		//        if(minMengde1.erLik(minMengde2))
		//            System.out.println("Like mengder");

		//			minMengde1.fjern(kule1);
		
		//			if (!minMengde1.erLik(minMengde2)) {
		//			System.out.println("Ulike mengder");
		//		}


		KjedetMengde <Bingokule>minMengde3 = new KjedetMengde<Bingokule>();
		KjedetMengde <Bingokule>minMengde4 = new KjedetMengde<Bingokule>();
		KjedetMengde <Bingokule>minMengde5 = new KjedetMengde<Bingokule>();

		for(int j=1; j <= 11; j=j+2){
			kule3 = new Bingokule(j);
			kule4 = new Bingokule(j+1);
			minMengde3.leggTil(kule3);
			minMengde4.leggTil(kule4);
		}
		for(int x=1; x <= 12; x++){
			kule5 = new Bingokule(x);
			minMengde5.leggTil(kule5);
		}


		minMengde3.leggTilAlle(minMengde4);
		minMengde3.fjernTilfeldig();

		Iterator<Bingokule> t= minMengde3.oppramser();
		while (t.hasNext()) {
			System.out.print(t.next());		
		}
		System.out.println();
		Iterator<Bingokule> y= minMengde5.oppramser();
		while (y.hasNext()) {
			System.out.print(y.next());		
		}
		System.out.println();

		if(minMengde3.erLik(minMengde5))
			System.out.println("minMengde10 og minMengde20 er Like mengder");



	}




}//class