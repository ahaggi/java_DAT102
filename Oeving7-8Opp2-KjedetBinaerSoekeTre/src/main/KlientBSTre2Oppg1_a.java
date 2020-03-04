package main;
import  java.util.*;

class KlientBSTre2Oppg1_a{
 public static void main(String[]a){
  //Lager BS-tre med 8 noder
  //Skriv ut i in-orden, dvs sortert
  //Sjekker om verdien 10 er i treet
  //
  
  final int ANTALL_NODER = 1024;
  Random tilfeldig = new Random(1);
  
  KjedetBSTre <Integer>bs = new KjedetBSTre<Integer>();
   
  for(int i = 0; i < ANTALL_NODER; i++){
   Integer element = new Integer(tilfeldig.nextInt(30));
   System.out.print(element+ " ");
   bs.leggTil(element);
  }
  System.out.println("\n");
  
  System.out.println("Treet med  " + ANTALL_NODER + " noder.");
    
  System.out.println("\n\nHar hoeyde med: "+bs.hoyde());

  System.out.println("\n\nDen minimale teoretiske h�yden: "+bs.minimaleTeoretiskeHoyden()); 

  System.out.println("\n\nDen minimale teoretiske h�yden: "+bs.minimaleTeoretiskeHoyden2());

  System.out.println("\n\nDen maksimale teoretiske h�yden: "+bs.maksemaleTeoretiskeHoyden());


//  iv) minste h�yde i l�pet av kj�ringene
//  v) st�rste h�yde i l�pet av kj�ringene
//  vi) gjennomsnittlig h�yde av alle kj�ringene
  
 }
}//class