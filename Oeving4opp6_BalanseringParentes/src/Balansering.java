import java.io.*;

import tabell_stabell.TabellStabel;
public class Balansering{    
	TabellStabel<Parentesinfo>stabel = new  TabellStabel<Parentesinfo>();  
	boolean erFeil=false;

	private boolean passer(char aapent, char lukket){
		switch(aapent){
		case '(': return (lukket == ')'); 
		case '[': return (lukket ==']');
		case '{': return (lukket == '}');
		default: return false;
		}
	}//


	public void foretaBalansering(String innDataStreng, int linjenr){

		int lengde = innDataStreng.length();
		boolean fortsatt= true;
		int i =0;
		while (i<lengde&&fortsatt) {
			if (innDataStreng.charAt(i)=='{' || innDataStreng.charAt(i)=='['|| innDataStreng.charAt(i)=='(' ) {
				Parentesinfo aapent=new Parentesinfo();
				aapent.setLinjenr(linjenr);
				aapent.setPosisjon(i);
				aapent.setVenstreparentes(innDataStreng.charAt(i));
				stabel.push(aapent);
			}else if (innDataStreng.charAt(i)=='}' || innDataStreng.charAt(i)==']'|| innDataStreng.charAt(i)==')' ) {
				char lukket=innDataStreng.charAt(i);
				if (stabel.erTom()){
					fortsatt=false;	
					System.out.println("Lukkesymbol "+lukket+" på linje "+linjenr+", tegn nr "+i+" mangler tilsvarende åpnesymbol");
					erFeil=true;
				}else{
					fortsatt=passer(stabel.pop().getVenstreparentes(), lukket) ;
					if (!fortsatt) {
						System.out.println("Lukkesymbol "+lukket+" på linje "+linjenr+", tegn nr "+i+" har feil åpnesymbol");
						erFeil=true;
					}
				}	
			}//else if
			i++;
		}

	}//



	public  void lesFraFil(String filnavn){
		FileReader tekstFilLeser = null;
		try{
			tekstFilLeser = new FileReader(filnavn);
		}
		catch(FileNotFoundException unntak){
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 1;
		try{
			linje = tekstLeser.readLine();
			while(linje != null){
				foretaBalansering(linje, linjenr);
				linjenr++;
				linje = tekstLeser.readLine();
			}//while
			while (!stabel.erTom()) {
				Parentesinfo p=stabel.pop();
				System.out.println("Åpnesymbol "+p.getVenstreparentes()+" på linje "+p.getLinjenr()+", tegn nr "+p.getPosisjon()+" har ikke tilsvarende lukkesymbol");
				erFeil=true;
			}
			if (!erFeil) {
				System.out.println("Ingen feil");
			}
		}   

		catch(IOException unntak){
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try{tekstFilLeser.close();}
		catch(IOException unntak){
			System.out.println("Feil ved lukking av fil!");
		}

	}//metode

}//class



