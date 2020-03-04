package medlem;


import Iterator.Iterator;
import mengde.kjedet.KjedetMengde;


public class Medlem {
	private String navn;
	private KjedetMengde<Hobby> hobbyer;
	private int statusIndeks;

	public Medlem(String nv){
		navn=nv;
		statusIndeks=-1;
		hobbyer=new KjedetMengde <Hobby>();
	}

	public void skrivUt(){
		System.out.println("Navn: "+getNavn()+"\nStatus: "+getStatusIndeks()+"\nHobby/-er:");
		//Iterator<Hobby> it=hobbyer.oppramser();
		System.out.println(getalleHobbyer());//vi kunne brukt oppramser istedet, men vi har allerede lagt toString metode i kjedetMengde klasse
	}

	public String getalleHobbyer(){
		String resultat = "";
		Iterator<Hobby> it=hobbyer.oppramser();
		while(it.hasNext()){
			resultat += it.next().toString() ;//legg merke til toString som er implemntert i Hobby klasse ikke i kjedetmenge klassen
		}
		return resultat;
	}

	public boolean passerTil(Medlem medlem2){
		Boolean b =false;
		int snitt=hobbyer.snitt(medlem2.hobbyer).antall();
		int antallHobby1=hobbyer.antall();
		int antallHobby2=medlem2.getHobbyer().antall();
		
		if (antallHobby1>1 && antallHobby2>1) {//de har mer enn 1 hobby
			if (snitt>=2) 
				b=true;
		}else{//de har bare 1 hobby
			if (hobbyer.erLik(medlem2.hobbyer))
				b=true;
		}



		return(b);

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public KjedetMengde<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

} 