package main;


//---------------------------------------------------------------------------
import java.util.Scanner;

import tabell_koe.TabellKoe;
class Kjøreplan1{
	
    public static void main(String[] args){
    	
        Scanner tastatur = new Scanner(System.in);
        JobbSamling js = new JobbSamling();
        TabellKoe<Jobb> klarKø = new TabellKoe<Jobb>();
        
        Jobb jobb = null;
        int klokke = 0;
        int tidskrav = 0;
        int antall = 0;

        //Leser fra fil
        System.out.print("Oppgi datafil:");
        String filnavn = tastatur.nextLine();
        System.out.println("Datafil: " + filnavn);
        
        js.lesFraFil(filnavn);
        antall = js.hentAntall();
        
        System.out.println("antall " + antall);
        JobbSamling ferdige = new JobbSamling(antall);

        while(ferdige.hentAntall() < antall){//Ytre løkke
            
            //Henter eventuelle jobber til klarkøen
            do{
                jobb = js.hentAnkommenJobb(klokke);
                if(jobb != null){
                    klarKø.innKoe(jobb);
                }
            }while(jobb != null);

            //Ta eventuelt ut jobb fra kø A til CPU
            if(klarKø.antall() > 0){
                jobb = klarKø.utKoe();
                tidskrav = jobb.getKjøretid();
                klokke = klokke + tidskrav;
                jobb.setFerdigTid(klokke);
                ferdige.leggTil(jobb);
             }else  // Ingen jobber klar til kjøring
                   klokke = klokke + 1;
         }//while       
                       
       
        ferdige.visJobber(); 
        tastatur.close();
    }//main
}//class