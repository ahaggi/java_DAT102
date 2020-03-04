package person;

import easyIO.*;
import kjede_koe.KjedetKoe;
import no.hib.dat102.listeordnet.adt.OrdnetListeADT;
import no.hib.dat102.listeordnet.kjedet.KjedetOrdnetListe;
import no.hib.dat102.listeordnet.tabell.TabellOrdnetListe;

public class Meny {

	Out skjerm= new Out();
	In tastValg=new In();
	String filnavn="register.txt";
	In innfil;
	String linje="************************************************************************";
	String linje2="------------------------------------------------------------------------";





	public Person lesFraFil(){
		Person person=null;
		// 4 - Les postene, en hel post om gangen
		String post = innfil.inLine();

		if (post!=null) {
			String[] personer = post.split(" ");
			String fornavn = personer[0];
			String etternavn =  personer[1];
			int fd =  Integer.valueOf(personer[2]);

			person = new Person(fornavn,etternavn,fd);
		}

		return person;
	}


	public void start(){



		String meny = "\n \n" + "1 - KØ-samling. \n"
				+ "2 - OrdnetListe.\n"
				+ "3 - Avslutter programmet.\n";

		String valg = "";

		do {

			skjerm.out(meny);
			valg = tastValg.inWord();

			switch (valg) {
			case "1":
				brukKØsamling();
				break;
			case "2":
				brukADTOrdnetListe();
				break;
			}

		} while (!valg.equals("3"));

	}


	public void brukKØsamling(){
		String meny = "\n \n" + "1 - Les inn nye personer KØ-samling \"les fra fil\". \n"
				+ "2 - Les inn nye 5 personer KØ-samling\"les fra tastatur\".\n"
				+ "3 - Skriv ut.\n"
				+ "4 - tilbake.\n\n";

		String valg = "";
		KjedetKoe<Person> personer=null;
		do {
			skjerm.out(meny);
			valg = tastValg.inWord();
			switch (valg) {

			case "1":
				personer=new KjedetKoe<>();//oppretter new hvergang
				innfil=new In(filnavn);
				Person p=lesFraFil();
				for (int i = 0; i < 9; i++) {
					personer.innKoe(p);
					p=lesFraFil();
				}
				break;
			case "2":
				personer=new KjedetKoe<>();//oppretter new hvergang
				innfil=new In(filnavn);

				for (int i = 0; i < 5; i++) {
					skjerm.outln("tast inn person nr "+i+", fornavn:");
					String fornavn = tastValg.inWord();
					skjerm.outln("tast inn person nr "+i+", etternavn:");
					String etternavn =   tastValg.inWord();
					skjerm.outln("tast inn person nr "+i+", fodselsaar:");
					int fd =tastValg.inInt();
					Person per = new Person(fornavn,etternavn,fd);
					personer.innKoe(per);
				}

				break;
			case "3":
				skjerm.out("Nr",3,3);skjerm.out("Fornavn",15,3);skjerm.out("etternavn",15,3);skjerm.outln("fodselsaar",10,3);
				if (personer!=null){
					int len=personer.antall();
					for (int i = 0; i < len; i++) {
						p=personer.utKoe();
						skjerm.out(i+1,3,3);skjerm.out(p.getFornavn(),15,3);skjerm.out(p.getEtternavn(),15,3);skjerm.outln(p.getFoedselsaar(),10,3);
					}

				}
				break;
			default:
				break;
			}

		} while (!valg.equals("4"));

	}

	public void brukADTOrdnetListe(){
		String meny = "\n \n" + "1 - KJEDET-ORDNETLISTE. \n"
				+ "2 - TABELL-ORDNETLISTE.\n"
				+ "3 - Skriv ut.\n"
				+ "4 - tilbake.\n\n";

		String valg = "";
		OrdnetListeADT<Person> personer=null;
		do {
			skjerm.out(meny);
			valg = tastValg.inWord();
			switch (valg) {

			case "1":
				personer=new KjedetOrdnetListe<>();//oppretter new hvergang
				brukOrdnetListe1(personer);

				break;
			case "2":
				personer=new TabellOrdnetListe<>();//oppretter new hvergang
				brukOrdnetListe1(personer);


				break;
			case "3":
				skjerm.out("Nr",3,3);skjerm.out("Fornavn",15,3);skjerm.out("etternavn",15,3);skjerm.outln("fodselsaar",10,3);
				if (personer!=null){
					int len=personer.antall();
					for (int i = 0; i < len; i++) {
						Person p=personer.fjernFørste();
						skjerm.out(i+1,3,3);skjerm.out(p.getFornavn(),15,3);skjerm.out(p.getEtternavn(),15,3);skjerm.outln(p.getFoedselsaar(),10,3);
					}

				}
				break;
			default:
				break;
			}

		} while (!valg.equals("4"));

	}
	public OrdnetListeADT<Person> brukOrdnetListe1(OrdnetListeADT<Person> adt){
		String meny = "\n \n" + "1 - Les inn nye personer ORDNETLISTE\"les fra fil\". \n"
				+ "2 - Les inn nye 5 personer ORDNETLISTE\"les fra tastatur\".\n"
				+ "3 - tilbake.\n\n";

		String valg = "";
		OrdnetListeADT<Person> personer=adt;
		
			skjerm.out(meny);
			valg = tastValg.inWord();
			switch (valg) {

			case "1":
				innfil=new In(filnavn);
				Person p=lesFraFil();
				for (int i = 0; i < 9; i++) {
					personer.leggTil(p);
					p=lesFraFil();
				}
				break;
			case "2":
				innfil=new In(filnavn);
				for (int i = 0; i < 5; i++) {
					skjerm.outln("tast inn person nr "+i+", fornavn:");
					String fornavn = tastValg.inWord();
					skjerm.outln("tast inn person nr "+i+", etternavn:");
					String etternavn =   tastValg.inWord();
					skjerm.outln("tast inn person nr "+i+", fodselsaar:");
					int fd =tastValg.inInt();
					Person per = new Person(fornavn,etternavn,fd);
					personer.leggTil(per);
				}

				break;
			default:
				break;
			}

		return personer;

	}

}//class