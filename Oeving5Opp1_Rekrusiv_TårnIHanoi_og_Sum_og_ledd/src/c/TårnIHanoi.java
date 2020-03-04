package c;

public class TårnIHanoi{
	private int antallRinger;
	private long antallFlyttinger;
	private long antallNullstilt=0;

	//Setter opp spillet med spesifisert antall	ringer.
	public TårnIHanoi (int startRinger){
		antallRinger = startRinger;
	}//metode

	//Utfører det første kallet til flyttRinger. Flytter ringene fra tårn 1 til tårn 3	ved å bruke tårn 2.
	public void spill(){
		flyttRinger (antallRinger, 1, 3, 2);
	}//metode

	//Flytter det spesifiserte antallet ringer fra et tårn til et annet ved å flytte
	//	n-1 ringer, deretter flytte en ring og til slutt
	//	flytte den de n-1 ringene. Rekursiv tenkning
	//	flytte n-1 ringer!
	private void flyttRinger (int antRinger,int start, int slutt, int temp){

		if (antRinger == 1){// Basistilfellet
			antallFlyttinger();
		}else{//Rolleskifte fra, til, mellom,

			antallFlyttinger();
			flyttRinger (antRinger-1, start, temp,slutt);
			flyttRinger (antRinger-1, temp, slutt,start);
		}

	}//metode

	private void antallFlyttinger() {
		if (antallFlyttinger==Math.pow(2, 32)) {
			antallFlyttinger=0;
			antallNullstilt++;
		}

		this.antallFlyttinger++;
	}

	public long getAntallFlyttinger() {
		return antallFlyttinger;
	}

	public long getAntallNullstilt() {
		return antallNullstilt;
	}

}