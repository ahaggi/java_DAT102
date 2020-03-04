
public class KlientRekSum {
	public static void main(String[] args){
		System.out.printf(" summen er: %d", sum(4));
		
		System.out.println("\n***************************************");
	
		stjerne(5);
		
		System.out.println("\n***************************************");
		int []tab={4,7,3,8,5,9,-2,3,1};
		System.out.println(finnMinste(0, tab));
		
		System.out.println("\n***************************************");
		
		System.out.println (regnUt(2,3));
		System.out.println(antall);
	}
	
	/**
	som finn verdien an basert på formelen 
	                            a^n = a^(n/2) * a^(n/2) når n er partal >0,
	                            a^n = a * a^(n/2) * a^(n/2) når n er oddetal > 0 og a0 = 1.0*/
	static int antall=0;
	public static double regnUt(double a,int n){
		System.out.println(antall++);
		if(n==0)
			return 1;
		
		
		if(n%2==0)
			return regnUt(a, n/2) * regnUt(a, n/2);
		else
			return a* regnUt(a, n/2) * regnUt(a, n/2);
		
		
	}

			 
	public static int finnMinste(int pos,int [] tab){
		if (pos==tab.length-1) {
			
			return tab[pos];
		}
		int nestePos=finnMinste(pos+1 , tab);
		int min =(tab[pos]<nestePos)?tab[pos]:nestePos;
		return min;
	}

	public static int sum(int n){
		//Summere de n første positive heltall: 1+2+3+…+n
		//Forkrav: n >= 0
		int resultat = 0;
		if (n == 1){
			resultat = 1;
		}
		else{
			resultat = n + sum(n-1); //Ser at et rek. kall er
		} // «mindre» enn foregående
		return resultat;
	}//metode

	static void stjerne (int n) {
		 if (n > 1) {
		 stjerne(n/2);
		  stjerne(n/2);
		 }
		 for (int i = 1; i <= n; i++) {
		 System.out.print("*");
		 }
		 System.out.println();
		 }
}

