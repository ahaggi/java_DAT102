package no.hib.dat102;

import easyIO.In;
import easyIO.Out;

public class Butikk {
	private int maksAntallVarer;
	private int antall=0;
	private String butikkNavn;
	private Vare[] varer;
	private int[] vLager;

	String linje="*******************************************";
	In tastatur = new In();
	Out skjerm = new Out();


	public Butikk(String s, int n){
		butikkNavn=s;
		maksAntallVarer= n;
		varer= new Vare[maksAntallVarer];
		vLager=new int[maksAntallVarer];

	}



	public int finnVare(int varenr){
		int varePosisjon=-1;
		for (int i = 0; i < antall&& varePosisjon==-1; i++) {
			if (varer[i].getVareNr()==varenr ) {varePosisjon=i;}
		}
		return varePosisjon;		
	}

	public boolean erLedigPlass(){
		return (antall<maksAntallVarer);
	}

	public void leggInnNyVare(){

		if (erLedigPlass()){
			System.out.println("Tast inn vare nr");
			int varenr=tastatur.inInt();

				if(finnVare(varenr)==-1) {
					Vare v= new Vare(varenr);
					varer[antall]=v;
					antall++;
					System.out.println("Tast inn tallet pه vare");
					int vMengde=tastatur.inInt();
					grossInnkjøp(varenr, vMengde);
				}else{
					System.out.println("Vare Nr: "+varenr+", er registrert fra fّr");
				}
				
		}else{
			System.out.println("Kan ikke legge til en ny vare fordi registeret er fult");
		}

	}

	public void slettVare(int varenr){
		int indx=finnVare(varenr);
		if (indx!=-1) {
			varer[indx]=varer[antall-1];
			varer[antall-1]=null;

			vLager[indx]=vLager[antall-1];
			vLager[antall-1]=0;

			antall--;
		}else{
			System.out.println("Vare Nr: "+varenr+", er ikke registeret i butikken");
		}
	}

	public void detaljSalg(int varenr){
		int indx=finnVare(varenr);
		if(indx!=-1){
			if (vLager[indx]>0) {
				vLager[indx]--;
			}else{
				System.out.println("Lageret er tom for vare Nr: "+varenr);
			}
		}else{
			System.out.println("Vare Nr: "+varenr+", er ikke registeret i butikken");
		}
	}

	public void grossInnkjøp(int varenr, int tall){
		int indx=finnVare(varenr);
		if(indx!=-1){
			if (tall>=0) {
				vLager[indx]=vLager[indx]+tall;
			}else{
				System.out.println("Feil inndata: "+tall+", er et negt. tall");
				System.out.println("Tast inn vare nr pه nytt");
				int vrnr=tastatur.inInt();
				System.out.println("Tast inn tallet pه vare");
				int vMengde=tastatur.inInt();
				grossInnkjøp(vrnr, vMengde);
			}
		}else{
			System.out.println("Vare Nr: "+varenr+", er ikke registeret i butikken");
		}
	}

	public double salgsVerdi(){
		double sum =0;
		for (int i = 0; i < antall; i++) {
			sum=sum+(vLager[i]*varer[i].getVarePris());
		}
		return sum;
	}

	public void skrivheader(){		
		skjerm.outln();
		System.out.println("Varer\\vare i buttik: "+butikkNavn);

		skjerm.out("Vare nr",10,3);
		skjerm.out("|");
		skjerm.out("Navn",10,3);
		skjerm.out("|");
		skjerm.out("Antall",10,3);
		skjerm.out("|");
		skjerm.out("Pris",10,3);
		skjerm.out("|");
		skjerm.outln();
		skjerm.outln(linje);
	}

	public void skrivInfo(int varenr){
		int indx=finnVare(varenr);
		if (indx!=-1){
			skjerm.out(varer[indx].getVareNr(),10,3);
			skjerm.out("|");
			skjerm.out(varer[indx].getVareNavn(),10,3);
			skjerm.out("|");
			skjerm.out(vLager[indx],10,3);
			skjerm.out("|");
			skjerm.out(varer[indx].getVarePris(),2,10,3);
			skjerm.out("|");
			skjerm.outln();
			skjerm.outln(linje);
		}else{
			System.out.println("Vare Nr: "+varenr+", er ikke registeret i butikken");
		}

	}


	public void skrivInfoAlle(){
		for (int i = 0; i < antall; i++) {
			skrivInfo(varer[i].getVareNr());
		}			
		System.out.println("Totalt verdi = "+salgsVerdi());
		skjerm.outln(linje);

	}

	public void lesInn(){
		In fil = new In("register.txt");
		while (!fil.lastItem()) {
			int vareNr = fil.inInt();
			String navn = fil.inWord();
			int talletPهVare = fil.inInt();
			double pris = fil.inDouble();

			if (erLedigPlass()&&finnVare(vareNr)==-1) {
				Vare v=new Vare(vareNr,navn,pris);
				varer[antall]=v;
				vLager[antall]=talletPهVare;
				antall++;
			}else{
				System.out.println("Vare Nr: "+vareNr+", fins fra fّr eller registeret er fult");
			}
		}
		fil.close();
	}


}
