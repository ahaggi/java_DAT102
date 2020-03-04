package medlem;

public class Hobby{
	private String hobbyNavn;
	
	public Hobby(String hobby){
		hobbyNavn = hobby;
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}

/** returnerer hobbynavnet med ”<” foran og ”>” bak
	@return som en String (Eksempel: <tegne og male> )
 * */
	@Override
	public String toString(){
		String hobbyString="<"+getHobbyNavn().trim()+ ">";
		return (hobbyString);
	}

	/**sammenligne to Hobby objecter
	 * @return boolean
	 */
	@Override
	public boolean equals(Object hobby2){ //
		Hobby hobbyDenAndre = (Hobby)hobby2;
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	} 
}// end Hobby