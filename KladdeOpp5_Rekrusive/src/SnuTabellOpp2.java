
public class SnuTabellOpp2 {
	public static void main(String[] args) {
		int [] tab={1,2,3,4};
		
		SnuTab(tab, 3);
	}


	public static void SnuTab(int [] tab, int ndx){
		if (ndx>=0) {
			System.out.print(tab[ndx]);
			SnuTab(tab, ndx-1);
		}//else basis gjør ingenting
	}



	public static void SnuTab2(int [] tab, int frst, int sist){
		if (frst<sist) {
			int temp=tab[frst];
			tab[frst]=tab[sist];
			tab[sist]=temp;
			SnuTab2(tab,frst-1, sist-1);
		}//else basis gjør ingenting
	}
}
