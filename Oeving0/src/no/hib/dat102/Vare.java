package no.hib.dat102;

import easyIO.*;

public class Vare {
	
	private int vareNr;
	private String vareNavn;
	private double varePris;
	
	public Vare(int vNr){
		In tastatur = new In();
		Out skjerm = new Out();
		skjerm.outln();
		
		skjerm.out("Tast inn navn p� varet: ");
		String vNvn= tastatur.inWord();
		skjerm.out("Tast inn prisen: ");
		double pr= tastatur.inDouble();
		while (pr<0) {
			skjerm.out("Feil inndata: prisen kan ikke bli neg. \n"
					+ "Tast inn prisen p� nytt: ");
			pr= tastatur.inDouble();
		}
		
		vareNr=vNr;
		vareNavn= vNvn;
		varePris= pr;
	}

	public Vare(int vNr, String vNvn, double pr){
 		Out skjerm = new Out();
		skjerm.outln();
				
		vareNr=vNr;
		vareNavn= vNvn;
		varePris= pr;
	}


	public int getVareNr() {
		return vareNr;
	}

	public void setVareNr(int vareNr) {
		this.vareNr = vareNr;
	}

	public String getVareNavn() {
		return vareNavn;
	}

	public void setVareNavn(String vareNavn) {
		this.vareNavn = vareNavn;
	}

	public double getVarePris() {
		return varePris;
	}

	public void setVarePris(double varePris) {
		this.varePris = varePris;
	}
	
	

}
