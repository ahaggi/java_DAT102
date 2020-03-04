package Bingokule;

public class Bingokule{
// Til å representer 'bingo-verdier' B10, N43, ... osv
//
    private char bokstav;
    private int tall;
    public Bingokule(int verdi){
    // Konstruktør med parameter mellom 1 og 75
    //
        tall = verdi;
        if(verdi<=15)
            bokstav = 'B';
        else if (verdi<=30)
            bokstav = 'I';
        else if (verdi<=45)
            bokstav = 'N';
        else if (verdi<=60)
            bokstav = 'G';
        else
            bokstav = 'O';
    }
        
    @Override
	public boolean equals(Object k2){
    // Til å teste om to bingokuler har samme verdi
    //
       Bingokule b2 = (Bingokule)k2; // Nødvendig typekonvertering
       return (tall == b2.tall && bokstav == b2.bokstav);
    }
     
    @Override
	public String toString(){
    // String-representasjon av bingokule (til utskrift)
        return bokstav + " " + tall;
    }
}//class
