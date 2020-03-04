package test;

import mengde.tabell.TabellMengde;

import static org.junit.Assert.*;
import org.junit.*;

import Iterator.Iterator;

/**
 * Test for KoeADT.
 * 
 */
public class testTabellMengde {

	// Referanse til mengden
	private TabellMengde<Integer> mengde1;
	private TabellMengde<Integer> mengde2;
	private TabellMengde<Integer> mengdebegge;
	private TabellMengde<Integer> mengdeSnitt;
	private TabellMengde<Integer> mengdeDiff;
	private TabellMengde<Integer> mengdeFasit;

	// Testdata
	private Integer [] m1 = {1,2,3,4,5,6,7};
	private Integer [] m2 = {6,7,8,9,10};

	/**
	 * Hent en ny koe for hver test.
	 */
	@Before
	public final void setup() {
		mengde1 = new TabellMengde<Integer>();
		mengde2 = new TabellMengde<Integer>();
		mengdebegge = new TabellMengde<Integer>();
		mengdeSnitt = new TabellMengde<Integer>();
		mengdeDiff = new TabellMengde<Integer>();
		mengdeFasit = new TabellMengde<Integer>();

		for (int i = 0; i < m1.length; i++) {
			mengde1.leggTil(m1[i]);
		}

		for (int i = 0; i < m2.length; i++) {
			mengde2.leggTil(m2[i]);
		}
	
	}
	/**
	 * Tester om megden er tom
	 */
	@Test
	public final void testAntall() {
		assertEquals(7, mengde1.antall());
		assertEquals(5, mengde2.antall());
	}

	/**
	 * Tester innKoe, utKoe ,  leggTil og innholder.
	 */
	@Test
	public final void testLeggTil() {}

	
	@Test
	public final void testUnion() {
		Integer [] fasit = {1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < fasit.length; i++) {
			mengdeFasit.leggTil(fasit[i]);
		}

		mengdebegge = (TabellMengde<Integer>)mengde1.union(mengde2);
		assertTrue(mengdebegge.erLik(mengdeFasit));

	}

	@Test
	public final void testUnion_forbedret() {
		Integer [] fasit = {1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < fasit.length; i++) {
			mengdeFasit.leggTil(fasit[i]);
		}

		mengdebegge = (TabellMengde<Integer>)mengde1.union_forbedret(mengde2);
		assertTrue(mengdebegge.erLik(mengdeFasit));

	}

	

	
	@Test
	public final void testOppramser() {
		Iterator<Integer> a=mengde1.oppramser();
		for (int i = 0; i < mengde1.antall(); i++) {
			System.out.print(a.next());
		}
	}

	
	@Test
	public final void TestSnitt() {
		Integer [] fasit = {6,7};
		for (int i = 0; i < fasit.length; i++) {
			mengdeFasit.leggTil(fasit[i]);
		}

		mengdeSnitt = (TabellMengde<Integer>) mengde2.snitt(mengde1);
		assertTrue(mengdeSnitt.erLik(mengdeFasit));

	}

	
	@Test
	public final void Test_1_Diff_2() {
		Integer [] fasit = {1,2,3,4,5};
		for (int i = 0; i < fasit.length; i++) {
			mengdeFasit.leggTil(fasit[i]);
		}

		mengdeDiff = (TabellMengde<Integer>) mengde1.differens(mengde2);
		assertTrue(mengdeDiff.erLik(mengdeFasit));

	}

	
	@Test
	public final void Test_2_Diff_1() {
		Integer [] fasit = {8,9,10};
		for (int i = 0; i < fasit.length; i++) {
			mengdeFasit.leggTil(fasit[i]);
		}

		mengdeDiff = (TabellMengde<Integer>) mengde2.differens(mengde1);
		assertTrue(mengdeDiff.erLik(mengdeFasit));

	}


}