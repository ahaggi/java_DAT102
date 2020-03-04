import java.util.Scanner;

public class KlientBalansering{
     public static void main(String[] args){
        
    	 System.out.println("tast inn navn på filen");
    	 Scanner sc = new Scanner(System.in);
        final String filnavn = sc.nextLine();
        sc.close();
        //Leser inn en tekst fra fil
        Balansering balansering = new Balansering();
        balansering.lesFraFil(filnavn);
 }//main

}//class
