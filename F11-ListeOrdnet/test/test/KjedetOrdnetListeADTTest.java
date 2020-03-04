package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.listeordnet.kjedet.KjedetOrdnetListe;

//package 

/**
 * Test av KjedetOrdnetListeADT med heltall.
 * 
 * @author Ole Olsen
 */	
public class KjedetOrdnetListeADTTest {   

	private KjedetOrdnetListe<Integer> liste;  

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	/**
	 * Opprett en liste for hver test.
	 * 
	 * @throws Exception exception
	 */
	@Before
	public final void setup() throws Exception {
		liste = new KjedetOrdnetListe<Integer>();
	}

	/**
	 * Tester om en ny liste er tom.
	 */
	@Test
	public final void nyListeErTom() {
		assertTrue(liste.erTom());
	}

	/**
	 * Tester leggTil og fjern.
	 */
	@Test
	public final void leggTilOgFjern() {
		liste.leggTil(e0);
		assertEquals(e0, liste.fjern(e0));


	}

	/**
	 * Tester ordning 
	 * 
	 */
	@Test
	public final void viseOrdnetVoksende() { 
		liste.leggTil(e1); 
		liste.leggTil(e4); 
		liste.leggTil(e3); 
		liste.leggTil(e0); 
		liste.leggTil(e5); 
		liste.leggTil(e2); 
		assertEquals(e0, liste.fjernFørste()); 
		assertEquals(e1, liste.fjernFørste());
		assertEquals(e2, liste.fjernFørste());
		assertEquals(e3, liste.fjernFørste());
		assertEquals(e4, liste.fjernFørste());
		assertEquals(e5, liste.fjernFørste());   
	}

	/**
	 * Tester ordning
	 * 
	 */
	@Test
	public final void viseOrdnetAvtagende(){
		liste.leggTil(e1); 
		liste.leggTil(e4); 
		liste.leggTil(e3); 
		liste.leggTil(e0); 
		liste.leggTil(e5); 
		liste.leggTil(e2); 
		assertEquals(e5, liste.fjernSiste()); 
		assertEquals(e4, liste.fjernSiste()); 
		assertEquals(e3, liste.fjernSiste()); 
		assertEquals(e2, liste.fjernSiste()); 
		assertEquals(e1, liste.fjernSiste()); 
		assertEquals(e0, liste.fjernSiste()); 

	}

	/**
	 * Tester leggTil og fjern med like verdier.
	 */
	@Test
	public final void leggTilOgfjernMedDuplikater() {
		liste.leggTil(e1); 
		liste.leggTil(e2); 
		liste.leggTil(e2); 
		liste.leggTil(e3); 
		liste.leggTil(e2); 
		assertEquals(e1, liste.fjernFørste()); 
		assertEquals(e2, liste.fjernFørste()); 
		assertEquals(e2, liste.fjernFørste()); 
		assertEquals(e2, liste.fjernFørste()); 
		assertEquals(e3, liste.fjernFørste()); 
	}

	/**
	 * Tester leggTil og inneholder
	 */
	@Test
	public final void leggTilOgInnholder() {
		liste.leggTil(e1); 
		liste.leggTil(e2); 
		liste.leggTil(e3); 
		liste.leggTil(e4); 
		liste.leggTil(e5); 
		liste.inneholder(e1);
		liste.inneholder(e2);
		liste.inneholder(e3);
		liste.inneholder(e4);
		liste.inneholder(e5);
	}

	/**
	 * Tester om listen med verdier ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		liste.leggTil(e1);
		assertFalse(liste.erTom());
	}

	/**
	 * Tester om leggTil og fjern på en tom liste gir en tom liste.
	 */
	@Test
	public final void leggTilFjernErTom() {
		liste.leggTil(e1);
		liste.fjern(e1);
		assertTrue(liste.erTom());
	}

	/**
	 * Prøver å fjerne et element fra en tom liste.
	 */
	@Test
	public final void fjernFraTomListe() {
		assertNull("Fjerne fra tom liste", liste.fjern(e4));
	}

}