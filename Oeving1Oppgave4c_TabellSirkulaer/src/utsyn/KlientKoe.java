package utsyn;

import tabell_koe.TabellKoeSirkular;

public class KlientKoe {
	public static void main(String[] args){
		
		//---------TabellSirkular-------------------------
		TabellKoeSirkular<Character> tegnKoe_sir = new TabellKoeSirkular<Character>();
		String streng_sir = " Denne koen er en FIFO datastruktur.";
		int lengde_sir = streng_sir.length();
		for(int i = 0; i < lengde_sir; i++){
			tegnKoe_sir.innKoe(new Character(streng_sir.charAt(i)));
		}
		System.out.println("Ved bruk av sirkulaer Tabell strukturert Koe ");
		while(!tegnKoe_sir.erTom()){
			Character tegn_obj_sir = tegnKoe_sir.utKoe();
			System.out.print(tegn_obj_sir);
		}
	}//main
}//class