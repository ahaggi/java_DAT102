package medlem;



public class Datakontakt {
	Medlem[] medlemmer;
	int antall;
	int parAntall;

	public Datakontakt(){
		this(20);
	}
	public Datakontakt(int ant){
		medlemmer=new Medlem[ant];
		antall= 0;
		parAntall=0;
	}


	public Medlem[] getMedlemmer() {
		return medlemmer;
	}
	public int getAntall() {
		return antall;
	}

	public int getParAntall() {
		return parAntall;
	}
	/******************************************************************
	utvider tabellen med ekstra plass (tabell.length*1.1)+1)
	legg merke til at hvis tabellen har 9 plasser,vil ikke skjer noe i tilfelle (koe.length*1.1)
	 ******************************************************************/
	private void utvidKapasitet() {
		Medlem [] hjelpeTabell = new Medlem[(int) ((medlemmer.length*1.1)+1)];
		for (int indeks =0; indeks < medlemmer.length; indeks++){
			hjelpeTabell[indeks] = medlemmer[indeks];
		}
		medlemmer = hjelpeTabell;
	}

	/**legger til et nytt medlem i medlemstabellen.*/
	public void leggTilMedlem(Medlem person){
		//sjekker om person er ikke med i tabellen
		if(finnMedlemsIndeks(person.getNavn())==-1) {
			if(antall==medlemmer.length){
				utvidKapasitet();
			}
			medlemmer[antall] = person;
			antall++;
		}
	}

	/** 
	 * @param String medlemsnavn
	 * @return int indeksen til medlemmet i	medlemstabellen, ellers returneres indeks lik -1.
	 */
	//(Noen vil kanskje si at i denne metoden burde returnerte en referansen slik at vi lettere
	//kunne bytte ut til annen datastruktur, men det lar vi være)
	public int finnMedlemsIndeks(String medlemsnavn){
		int ndx =-1;
		for(int i=0;i<antall&&(ndx==-1);i++){
			if (medlemmer[i].getNavn().equals(medlemsnavn)) {
				ndx=i;
			}
		}
		return ndx;
	}





	/**	finner ut om et medlem(identifisert med medlemsnavn) passer med et annet medlem (dersom det finnes) i medlemstabellen.
	 *  Dette medlemmet skal være det første som passer og ikke er “koblet”. 
	 *  Metoden oppdaterer medlemstabellen dersom det finner en partner, og	returnerer eventuell indeks til partneren i medlemstabellen (eller -1).
	 *	@param String medlemsnavn
	 *	@return int indeks til partneren,(eller -1).
	 */	
	public int finnPartnerFor(String medlemsnavn){
		int medlem2_Ndx=-1;

		//finner medlem1 i tabellen
		int medlem1_Ndx=finnMedlemsIndeks(medlemsnavn);

		//tester om medlem1 fins 
		if (medlem1_Ndx!=-1 ) {
			Medlem medlem1=medlemmer[medlem1_Ndx];
			if (medlem1.getStatusIndeks()==-1) {
				//søk etter medlem2 som har lik hobbyerMengde
				Medlem medlem2=null;
				for (int i = 0; i < antall && medlem2_Ndx==-1; i++) {
					medlem2=medlemmer[i];
					if (medlem2.getStatusIndeks()==-1 && !medlem1.equals(medlem2)) {
						if (medlem1.passerTil(medlem2)) {
							medlem2_Ndx=i;
							medlem1.setStatusIndeks(medlem2_Ndx);
							medlem2.setStatusIndeks(medlem1_Ndx);
							parAntall++;
						}//if passer
					}//if 
				}//for
			}
			medlem2_Ndx=medlem1.getStatusIndeks();//unngår uendelig loop ved lesning fra fil
		}//if gitt param "medlem1.navn" er registerert i tabellen
		return medlem2_Ndx;

	}


	/**oppdaterer medlemstabellen, slik at dette medlemmet (identifisert ved medlemsnavn) og dets partner, dersom det fins,
	 * ikke lenger er “koblet” (dvs. begge får statusindeks –1)
	 * @param String medlem1
	 */
	public void tilbakestillStatusIndeks(String medlemsnavn){
		int medlem1_Ndx=finnMedlemsIndeks(medlemsnavn);
		if (medlem1_Ndx!=-1) {
			Medlem medlem1=medlemmer[medlem1_Ndx];

			//kjekker om medlem1 er koblet
			if (medlem1.getStatusIndeks()!=-1) {
				Medlem medlem2=medlemmer[medlem1.getStatusIndeks()];
				medlem1.setStatusIndeks(-1);
				medlem2.setStatusIndeks(-1);
				parAntall--;
			}//if
		}//if

	}





}
