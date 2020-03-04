

public class Klient {

	public static void main(String[] args) {

		Integer [] m1 = {2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31};

		Integer[] liste = new Integer[m1.length];

		for (int i = 0; i < m1.length; i++) {
			liste[i]=m1[i];
		}
		System.out.println( Soek.binaerSokRekursiv(liste, 0, 14, 16));

	}

}
