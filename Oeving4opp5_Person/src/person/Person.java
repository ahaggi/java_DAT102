package person;

public class Person implements Comparable<Person>{
	private String fornavn;
	private String etternavn;
	private int foedselsaar;
	
	public Person(String fn, String etn, int faar){
		fornavn=fn;
		etternavn=etn;
		foedselsaar=faar;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public int getFoedselsaar() {
		return foedselsaar;
	}
	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}
	@Override
	public String toString() {
		return ", foedselsaar=" + foedselsaar + ",  etternavn=" + etternavn +"Fornavn=" + fornavn + "\n";
	}
	@Override
	public int compareTo(Person denAndre) {
		int res=0;
		if (this.getFoedselsaar()== denAndre.getFoedselsaar()) {
			if (this.getEtternavn().equals(denAndre.getEtternavn())) {
				if (!this.getFornavn().equals(denAndre.getFornavn())) //ikke lik fornavn
					res= this.getFornavn().compareTo(denAndre.getFornavn());
			}else//ikke lik etternavn
				res= this.getEtternavn().compareTo(denAndre.getEtternavn());
			
		}else{//ikke like fodselsår
			res=this.getFoedselsaar()-denAndre.getFoedselsaar();
		}
		return (res);
	}





}
