package main;
public class Jobb implements Comparable <Jobb> {

    //Egenskaper
    private int jobbnr;
    private int ankomsttid;
    private int kjøretid;
    private int ferdigtid;

    //Konstruktører
    public Jobb(int jnr, int kjtid, int anktid){
        jobbnr = jnr;
        ankomsttid = anktid;
        kjøretid = kjtid;
        ferdigtid = -1;

    }


 public int getKjøretid(){
    return kjøretid;
 }//


 public int getAnkomstTid(){
    return ankomsttid;
 }//

public void setFerdigTid(int ferdig){
    ferdigtid = ferdig;
 }//


public int getFerdigTid(){
    return ferdigtid;
 }//


public int finnVenteTid(){
    if(ferdigtid != -1)
         return ((ferdigtid - ankomsttid) - kjøretid);
     else
        return 0;
}//


@Override
public int compareTo(Jobb denAndre){
	int svar = 0;

	if(kjøretid < denAndre.getKjøretid()){
		svar = -1;
	}else if(kjøretid > denAndre.getKjøretid()){
		svar = 1;
	}else{// sammenligner ankomsttidene
	    if(ankomsttid < denAndre.getAnkomstTid())
	    	svar = -1;
		

	    else if(ankomsttid > denAndre.getAnkomstTid())
	    	svar = 1;

	    else
	    	svar = 0;
	}
	return svar;
}//


@Override
public String toString(){
  return(jobbnr + "\t\t\t" + ankomsttid +  "\t\t\t" + kjøretid + "\t\t\t" +  ferdigtid + "\t\t\t" +
  	 finnVenteTid() + "\t\t\t");
}//

}//class