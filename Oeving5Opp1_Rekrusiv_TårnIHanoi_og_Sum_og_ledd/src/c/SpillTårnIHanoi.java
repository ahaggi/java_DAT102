package c;

import java.time.*;
import java.util.Scanner;

public class SpillTårnIHanoi{

	public static void main(String[] args){
		//leser inn tallet på ringer fra tastatur
		Scanner tast=new Scanner(System.in);
		System.out.print("tast inn antall ringer:");
		int antallRinger= tast.nextInt();
		tast.nextLine();
		
		System.out.print("tast inn antall ringer:");

		Instant start = Instant.now();

		//utfører 
		TårnIHanoi tårn = new TårnIHanoi (antallRinger);
		tårn.spill();
		
		Instant end = Instant.now();
	    long tid = Duration.between(start, end).toNanos();

		System.out.println("antallFlyttinger= ("+tårn.getAntallNullstilt()+" X 2˄32) + "+tårn.getAntallFlyttinger()+" ganger, brukt tid: "+tid+" ns." );
		tast.close();
	}//main
}//class
