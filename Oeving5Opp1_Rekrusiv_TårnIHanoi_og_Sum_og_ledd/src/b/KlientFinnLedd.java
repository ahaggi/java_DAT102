package b;

public class KlientFinnLedd {
	public static void main(String[] args){
		for (int i = 0; i < 10; i++) {
		System.out.println("a("+i+") er: "+ finn(i));
		}
		}
	
			
	public static int finn(int n){
		//Summere de n første positive heltall: 1+2+3+…+n
		//Forkrav: n >= 0
		int resultat = 0;
		if (n==0){
			resultat = 2;
		}
		else if (n==1){
			resultat = 5;
		}
		else if (n>1){
			resultat = 5*finn(n-1) - 6*finn(n-2) +2;
		} // «mindre» enn foregående
		return resultat;
	}//metode
}