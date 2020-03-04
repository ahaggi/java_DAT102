package test;

import adt_en.KoeADT;
import tabell_koe.TabellKoeSirkular;

import static org.junit.Assert.*;
import org.junit.*;

import adt_en.EmptyCollectionException;

/**
 * Test for KoeADT.
 * 
 */
public class KoeADTTestSirkularTabell {
	
	/**
	 * Size of the tested stabel.
	 */
	protected static final int SIZE = 5;


	// Referanse til koen
	private KoeADT<Integer> koe;//kan ikke få takk i metoder som ikke står på koeADT 

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	/**
	 * Hent en ny koe for hver test.
	 */
	@Before
	public final void setup() {
		koe = new TabellKoeSirkular<Integer>(SIZE);
	}
	/**
	 * Tester om koen er tom
	 */
	@Test
	public final void newStackIsEmpty() {
		assertTrue(koe.erTom());
	}

	/**
	 * Tester innKoe, utKoe ,  leggTil og innholder.
	 */
	@Test
	public final void InnogUt() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoen failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Tester innkoe og utkoe med duplicated verdier.
	 */
	@Test
	public final void innOgUtDuplicates() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utkoe failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Testing foerste.
	 */
	@Test
	public final void innUtInnInnUt_foerste() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);
			koe.utKoe();
			assertEquals(e4, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("innkoe og utkoe failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Tester at koen med noen elementer ikke er tom .
	 */
	@Test
	public final void isNotEmpty() {
		koe.innKoe(e0);
		assertFalse(koe.erTom());
	}

	/**
	 * Tester at å utfoere innkoe og etterpå utkoe på en tom koe resulteter i en tom koe 
	 */
	@Test
	public final void innKoe_utKoe_IsEmpty() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("utkoen failed unexpectedly " + e.getMessage());
		}
	}

	/**
     * Tester om stabelen utvider seg riktig. koen pه to flere elementer 
     * enn koetabellen har plass til, sjekker om antallet er riktig,
     * tar ut og sjekker fّrste element, tar ut de i "midten",
     * tar ut og sjekker det siste elementet og sjekker til slutt
     * at kّen er tom slik det forventes.
     */
	
    @Test
    public final void utviderKoeSeg() {
        koe.innKoe(e1);
        for (int i = 0; i < SIZE; i++) {
            koe.innKoe(e0);
        }
        koe.innKoe(e2);
        assertEquals(SIZE + 2, koe.antall());
        assertEquals(e1, koe.utKoe());
        for (int i = 0; i < SIZE; i++) {
            koe.utKoe();
        }
        assertEquals(e2, koe.utKoe());
        assertTrue(koe.erTom());
    }


	
	
	
	/**
	 * Trying to utKoe an element from an empty Koe, should give an underflow
	 * exception.
	 * 
	 * @throws EmptyCollectionException
	 *             expected exception
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void utKoeFromEmptyIsUnderflowed() throws EmptyCollectionException {
		koe.utKoe();
	}


}
