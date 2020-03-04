package no.hib.dat102;


/**
 * Feilhåndtering for karakter.
 * 
 * @author Ole Olsen
 */
public class FeilKarakterException extends Exception {


 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
  * Lager et nytt unntak.
  * 
  * @param melding melding
  */
 public FeilKarakterException(String melding) {
  super(melding);
 }

}
