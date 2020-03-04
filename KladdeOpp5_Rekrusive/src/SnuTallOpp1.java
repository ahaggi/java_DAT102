
public class SnuTallOpp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnuTall(123);
	}
public static void SnuTall(int tall){
	if (tall>0) {
		System.out.print(tall%10);
		SnuTall(tall/10);
	}
}
}
