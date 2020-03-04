/**
 * 
 */
package utsyn;

import java.io.*;
import medlem.*;

/**
 * @author Ole Olsen
 * 
 */
public class Fil {

	private static String SKILLE = " ";
	private Datakontakt datakontakt;


	public Fil(Datakontakt datakontakt){
		this.datakontakt = datakontakt;

	}

	/**
	 * @param filnavn
	 * @return Referansen til CD-arkivet
	 * @throws java.io.IOException
	 */
	public Datakontakt lesFraFil(String filnavn) throws java.io.IOException {


		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			// 4 - Les postene, en hel post om gangen
			String post = innfil.readLine();
			while (post!=null) {
				String nv = post;
				Medlem medlem = new Medlem(nv);


				//leser hobbyer
				post = innfil.readLine();
				String[] hobbyListe = post.split(SKILLE);
				for (int i = 0; i < hobbyListe.length; i++) {
					Hobby hobby= new Hobby(hobbyListe[i]);
					medlem.getHobbyer().leggTil(hobby);
				}
				
				
				//leggertil den leste medlemen til datakontakt
				datakontakt.leggTilMedlem(medlem);
				
				//leser en  nymedlem
				post = innfil.readLine();

			}

			// 4 - Lukk filen
			innfil.close();

		} 
		catch (FileNotFoundException unntak) {//arver fra IOException mه stه fّrst
			// hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(-1);
		} 
		catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(1);
		}
		return datakontakt;
	}



//	public void skrivTilFil(CDarkivADT cdarkiv, String filnavn, boolean utvid) throws java.io.IOException {
//
//		CD hjelpeTabell[]= cdarkiv.hentCdTabell();
//		try {
//			// // 1 - FileWriter
//			FileWriter ansFil = new FileWriter(filnavn,false);
//
//			// 2 - PrintWriter
//			PrintWriter utfil = new PrintWriter(ansFil);
//
//			if (hjelpeTabell.length!=0) {
//				int cdNr,lansAar, sj;
//				String artistNv,cdTittel,plSels;
//
//				for (int i = 0; i < cdarkiv.hentAntall(); i++) {
//					cdNr=hjelpeTabell[i].getCdNumer();
//					artistNv=hjelpeTabell[i].getArtistNavn();
//					cdTittel=hjelpeTabell[i].getCdTittle();
//					lansAar=hjelpeTabell[i].getLansAar();
//					sj=hjelpeTabell[i].getSjange().getNr();
//					plSels=hjelpeTabell[i].getPlateselskap();
//					utfil.println(cdNr+SKILLE+artistNv+SKILLE+cdTittel+SKILLE+lansAar+SKILLE+ sj+SKILLE+plSels); 
//				}//for
//			}//if
//
//			// 4 - Lukk filen
//			utfil.close();
//
//		} 
//		catch (FileNotFoundException unntak) {//arver fra IOException mه stه fّrst
//			// hvis ikke vil unntaket for IOException skygge
//			System.out.println("Finner ikke filen " + filnavn);
//			System.exit(-1);
//		} 
//		catch (IOException e) {
//			System.out.println("Feil ved skriving pه fil: " + e);
//			System.exit(1);
//		}
//
//	}

}// class
