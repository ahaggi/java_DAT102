package test;

import static org.junit.Assert.*;

import org.junit.*;
import main.*;

import org.junit.Before;

public class KjedetBSTreTest {

	private KjedetBSTre<Integer> bs;
	// Testdata som legges inn i treet
	private Integer[] e = {1,2,3,4,5,6,7};
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;

 
	/**
	 * Opprett en tomt tre for hver test.
	 * 
	 * @throws Exception
	 *             exception
	 */
	@Before
	public final void setup() throws Exception {
		bs = new KjedetBSTre<Integer>();
		for (int i = 0; i < 7; i++) {
			bs.leggTil(new Integer(e[i]));
		}
	}

	/**
	 * Tester finn
	 * 
	 */
	@Test
	public final void erElementIBSTre() {

		int i = 0;
		for (Integer el : bs) {
			assertEquals(e[i], el);
			i++;
		}
	}

	/**
	 * 1. Tester ordning ved � legge til elementer og fjerne minste
	 * 
	 */
	@Test
	public final void erBSTreOrdnet() {
		for (int j = 0; j < 7; j++) {
			assertEquals(e[j], bs.fjernMin());

		}
	}

	/**
	 * 2 Tester ordning ved � bruke en inordeniterator Her studerer du alt om
	 * bruk av inordeniterator.
	 */
	@Test
	public final void erBSTreOrdnet2() {
		for (int j = 0; j < 7; j++) {
			bs.fjernMin();
		}

		bs.leggTil(e3);
		bs.leggTil(e2);
		bs.leggTil(e4);
		bs.leggTil(e1);
		bs.leggTil(e5);
		bs.leggTil(e0);
		bs.leggTil(e6);

		Integer el[] = { e0, e1, e2, e3, e4, e5, e6 };
		int i = 0;
		for (Integer e : bs) {
			assertEquals(el[i], e);
			i++;
		}

	}

}// class
