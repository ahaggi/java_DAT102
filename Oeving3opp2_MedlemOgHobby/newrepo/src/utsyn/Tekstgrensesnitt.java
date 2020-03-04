package utsyn;

import easyIO.*;
import medlem.Datakontakt;
import medlem.Hobby;
import medlem.Medlem;

public class Tekstgrensesnitt{ 
	In tast= new In();
	Out skjerm = new Out();
	String linje="************************************************************************";
	String linje2="------------------------------------------------------------------------";




	/** leser opplysningene om et medlem fra tastatur
	 * @return Medlem medlem*/
	public Medlem lesMedlem(){
		skjerm.outln("Tast inn medlems navn:");
		String nv=tast.inLine();
		Medlem medlem1=new Medlem(nv);

		skjerm.outln("Tast inn medlems hobbyer, (avslutt listen med zzz) :");
		String hobbynv=tast.inLine();
		while (!hobbynv.equals("zzz")) {
			Hobby hobby= new Hobby(hobbynv);
			medlem1.getHobbyer().leggTil(hobby);
			skjerm.outln("Tast inn medlems hobbyer (avslutt listen med zzz) :");
			hobbynv=tast.inLine();
		}
		return medlem1;		 
	}


	public Medlem finnMedlem(Datakontakt datakontakt, String nv){
		int ndx=datakontakt.finnMedlemsIndeks(nv);
		Medlem medlem=null;
		if (ndx!=-1) {
			medlem=datakontakt.getMedlemmer()[ndx];
		}
		return medlem;		
	}

	/** skriver ut hobbylisten for et medlem
	 * @param Medlem medlem*/
	public void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getalleHobbyer());
	}

	/** skriver ut på skjermen en oversikt over medlemmer som er
	 koblet til hverandre i medlemstabellen til enhver tid.
	 Et slikt par skal kun vises én gang på utskriftlisten.
	 Metoden skriver også ut antall par som er funnet.*/
	public void skrivParListe (Datakontakt datakontakt) {
//		int [] hjelpeTabell = new int [datakontakt.getAntall()];
//		Medlem [] medlemmer=datakontakt.getMedlemmer();
//
//		for (int i = 0; i < hjelpeTabell.length; i++) {
//			if (hjelpeTabell[i]!=-2 && medlemmer[i].getStatusIndeks()!=-1) {//setter -2 for den medlem som er allerede bl
//				hjelpeTabell[i]=medlemmer[i].getStatusIndeks();
//				hjelpeTabell[medlemmer[i].getStatusIndeks()]=-2;
//			}else{
//				hjelpeTabell[i]=-2;
//			}
//		}
//
//		skjerm.out("PARNAVN",30,3);		skjerm.outln("HOBBYER",40,3);
//		skjerm.outln(linje);
//
//		for (int i = 0; i < hjelpeTabell.length ; i++) {
//			if (hjelpeTabell[i]!=-2) {
//				String parnavn = medlemmer[i].getNavn()+" og "+ medlemmer[hjelpeTabell[i]].getNavn();
//				skjerm.out(parnavn,30,3); skjerm.out("|");
//				skjerm.out(medlemmer[i].getalleHobbyer(),40,3);  skjerm.outln("|");
//				skjerm.outln(linje2);
//			}
//		}
//		skjerm.out("antall par funnet: "); skjerm.outln(datakontakt.getParAntall());

		
		Medlem [] medlemmer=datakontakt.getMedlemmer();
		skjerm.out("PARNAVN",30,3);		skjerm.outln("HOBBYER",40,3);
		skjerm.outln(linje);

		for (int i = 0; i < datakontakt.getAntall() ; i++) {
			if (medlemmer[i].getStatusIndeks()!=-1 && medlemmer[i].getStatusIndeks()>i) {
				String parnavn = medlemmer[i].getNavn()+" og "+ medlemmer[medlemmer[i].getStatusIndeks()].getNavn();
				skjerm.out(parnavn,30,3); skjerm.out("|");
				skjerm.out(medlemmer[i].getalleHobbyer(),40,3);  skjerm.outln("|");
				skjerm.outln(linje2);
			}
		}
		skjerm.out("antall par funnet: "); skjerm.outln(datakontakt.getParAntall());

	}

	/** finnPartnerFor
	 * @param Medlem medlem
	 * @return partners Ndx eller -1
	 * */
	public int finnPartnerFor(Datakontakt datakontakt, String medlemsnavn){
		return datakontakt.finnPartnerFor(medlemsnavn);
	}


	public void finnPartnerForAlle(Datakontakt datakontakt){
		Medlem [] medlemmer=datakontakt.getMedlemmer();
		for (int i = 0; i < datakontakt.getAntall(); i++) {
			if (medlemmer[i].getStatusIndeks()==-1) {
				finnPartnerFor(datakontakt, medlemmer[i].getNavn());
			}
		}
	}
	public void finnMedlemmerUtenPartner(Datakontakt datakontakt){
		Medlem [] medlemmer=datakontakt.getMedlemmer();
		int [] hjelpeTabell = new int [datakontakt.getAntall()];
		int utenPartner=0;
		for (int i = 0; i < datakontakt.getAntall(); i++) {
			if (medlemmer[i].getStatusIndeks()==-1) {
				hjelpeTabell[utenPartner]=i;
				utenPartner++;
			}
		}//for
		
		skjerm.out("PARNAVN",30,3);		skjerm.outln("HOBBYER",40,3);
		skjerm.outln(linje);
		
		for (int i = 0; i < utenPartner; i++) {
			String navn = medlemmer[hjelpeTabell[i]].getNavn();
			skjerm.out(navn,30,3); skjerm.out("|");
			skjerm.out(medlemmer[hjelpeTabell[i]].getalleHobbyer(),40,3);  skjerm.outln("|");
			skjerm.outln(linje2);
			
		}
		skjerm.out("antall medlemmer funnet: "); skjerm.out(utenPartner);skjerm.outln("medlem");

		
		
	}

	public void tilbakestillStatusIndeks(Datakontakt datakontakt, String medlemsnavn){
		datakontakt.tilbakestillStatusIndeks(medlemsnavn);
	}

	public String getLinje() {
		return linje;
	}

	public void setLinje(String linje) {
		this.linje = linje;
	}

	public String getLinje2() {
		return linje2;
	}

	public void setLinje2(String linje2) {
		this.linje2 = linje2;
	}


}