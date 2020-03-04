
public class Soek {

	/**Lineær søking i usortert tabell*/
	public static <T extends Comparable<? super T>>
	boolean lineærSøkUsortert(T[] data,int min, int maks,T el){
		int indeks = min;
		boolean funnet = false;
		while (indeks <= maks && ! funnet){
			if(data[indeks]. compareTo(el) == 0){
				funnet = true;
			}
			indeks++;
		} //while
		return funnet;
	} //metode



	/**Lineær søking i sortert tabell*/
	public  static <T extends Comparable<? super T>> //så vi kan sammenligne avledete klasser
	boolean linearSokS(T[] data, int min, int maks, T el){
		int indeks = min;
		boolean funnet = false;
		while(indeks < maks && el.compareTo (data[indeks]) > 0){
			indeks++;
		}//while
		if(data[indeks]. compareTo(el) == 0){
			funnet = true;
		}
		return funnet;
	}//metod



	/**Binærsøk rekursiv*/
	public static <T extends Comparable<T>> boolean
	binaerSokRekursiv(T[] data, int min, int maks, T el){
		
		int i=min;
		while (i<=maks){
			System.out.print(data[i]+ " ");
			i++;
		}
		System.out.println("");
		
		if (min > maks){ // basistilfelle, ingen element
			return false;
		}
		int midtpunkt = (min + maks) / 2;

		//legg merke til den er mer effiktiv enn boken sin kode (der bruker koden compareTo 2 ganger for det samme elementet )
		int resultat = el.compareTo(data[midtpunkt]);

		if (resultat == 0){ // basistilfelle, finner elementet
			return true;
		}
		if(resultat < 0){// (her vil også fungere med else if)
			return binaerSokRekursiv(data, min, midtpunkt-1, el);
		} else { // resultat > 0
			return binaerSokRekursiv(data, midtpunkt+1, maks, el);
		}
	}//


	public static <T extends Comparable<T> >
	int binaerSokIKKErekursiv(T[] data, int min, int maks, T el){
		// Returnerer indeksen til målelementet hvis det fins ellers -1
		int forste = min; int siste = maks; int indeks = -1;
		boolean funnet = false;
		int resultat = 0;
		while((forste <= siste) && !(funnet)){
			int midtpunkt = (forste + siste)/2;
			resultat = el.compareTo(data[midtpunkt]);
			if(resultat == 0){
				funnet = true;
				indeks = midtpunkt;
			}
			else if(resultat < 0){//Søk i nedre halvdel
				siste = midtpunkt -1;
			}
			else {//Søk i øvre halvdel
				forste = midtpunkt + 1;
			}
		}//while
		return indeks;
	}//
}