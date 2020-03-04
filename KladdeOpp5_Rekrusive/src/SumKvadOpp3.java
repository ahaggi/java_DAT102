
public class SumKvadOpp3 {
	public static void main(String[] args) {

		
		System.out.println(sumKvadOpp(2 , 5));
		System.out.println(sumKvadNed(2 , 5));
	}


	public static int sumKvadOpp(int m, int n){
		int sum=0;
		if (m<=n) {
			sum=(m*m) + sumKvadOpp(m+1, n);
		}//else basis gjør ingenting
		return sum;
	}
	
	public static int sumKvadNed(int m, int n){
		int sum=0;
		if (m<=n) {
			sum=(n*n) + sumKvadNed(m, n-1);
		}//else basis gjør ingenting
		return sum;
	}

}
