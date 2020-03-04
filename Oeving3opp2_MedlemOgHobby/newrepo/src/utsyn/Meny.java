package utsyn;

import java.io.IOException;

import easyIO.In;
import easyIO.Out;
import medlem.Datakontakt;
import medlem.Medlem;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private Datakontakt datakontakt;
	private Fil fil;
	Out skjerm= new Out();
	In tastValg=new In();
	
	public Meny(Datakontakt dt){
		this.datakontakt = dt;
		tekstgr = new Tekstgrensesnitt();
		fil = new Fil(datakontakt);
	}
	
	public void start() throws IOException{
		
		//Oppretter CDarkiv først og leser fra fil
		datakontakt=fil.lesFraFil("register.txt");


		String melding2 ="Det er "+	datakontakt.getAntall()+" medlemmer registrerte i arkivet";
		skjerm.outln(melding2);
		skjerm.outln(tekstgr.getLinje());
		//

		String meny = "\n \n" + "1 - legge inn nye medlem \"les fra tastatur\". \n"
				+ "2 - Skriv ut en medlem hobbyer.\n"
				+ "3 - Skriv ut alle parene.\n"
				+ "4 - Finn partner for en medlem.\n"
				+ "5 - Finn partner Auto.\n"
				+ "6 - Tilbakestill StausIndeks for et par.\n"
				+ "7 - Skriv ut alle medlemmene uten partner.\n"
				+ "8 - avslutter programmet.\n";

		String valg = "";

		do {
			
			skjerm.out(meny);
			valg = tastValg.inWord();

			switch (valg) {
			case "1":
				datakontakt.leggTilMedlem(tekstgr.lesMedlem());
				break;
			case "2":
				skjerm.outln("Tast inn medlems navn som du søker etter");
				String medlemsNv=tastValg.inLine();
				Medlem medlem =tekstgr.finnMedlem(datakontakt, medlemsNv);
				if (medlem!=null) {
					tekstgr.skrivHobbyListe(medlem);
				}else System.out.println("inngitt navn er ikke registerert i arkivet");
				
				break;
			case "3":
				tekstgr.skrivParListe(datakontakt);
				break;
			case "4":
				skjerm.outln("Tast inn medlems navn");
				medlemsNv=tastValg.inLine();
				int partnerNdx=tekstgr.finnPartnerFor(datakontakt, medlemsNv);
				if (partnerNdx!=-1) {
					Medlem medlem2=datakontakt.getMedlemmer()[partnerNdx];
					String medlem2Nv=medlem2.getNavn();
					System.out.println(medlem2Nv +", er funnet som partner");
				}else System.out.println("fins ikke passende partner");

				break;
			case "5":
				tekstgr.finnPartnerForAlle(datakontakt);
				break;
			case "6":
				skjerm.outln("Tast inn navn på en av paret");
				medlemsNv=tastValg.inLine();
				tekstgr.tilbakestillStatusIndeks(datakontakt, medlemsNv);
				
				break;
			case "7":
				tekstgr.finnMedlemmerUtenPartner(datakontakt);
				break;

			default:
				break;
			}
				
			} while (!valg.equals("8"));

	}
}//class