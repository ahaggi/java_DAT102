package a;

public class KlientRekSum {
	public static void main(String[] args) {
		System.out.printf(" summen er: %d", sum(100));



	}

	public static int sum(int n) {
		// Summere de n første positive heltall: 1+2+3+…+n
		// Forkrav: n >= 0
		int resultat = 0;
		if (n == 1) {
			resultat = 1;
		} else {
			resultat = n + sum(n - 1); // Ser at et rek. kall er
		} // «mindre» enn foregående
		return resultat;
	}// metode
}