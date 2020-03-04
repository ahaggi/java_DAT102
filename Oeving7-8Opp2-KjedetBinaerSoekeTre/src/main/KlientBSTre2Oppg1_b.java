package main;

import java.util.*;

class KlientBSTre2Oppg1_b {
	final static int ANTALL_NODER = 1024;
	final static int ANTALL_KJORINGER = 100;

	public static void main(String[] a) {

		int bsMinsteHoyde = ANTALL_NODER;
		int bsStoersteHoyde = 0;
		int bsTotaltHoyde = 0;

		for (int i = 0; i < ANTALL_KJORINGER; i++) {
			KjedetBSTre<Integer> bs = lagNyTre();
			bsMinsteHoyde = (bs.hoyde() < bsMinsteHoyde) ? bs.hoyde() : bsMinsteHoyde;
			bsStoersteHoyde = (bs.hoyde() > bsStoersteHoyde) ? bs.hoyde() : bsStoersteHoyde;
			bsTotaltHoyde = bsTotaltHoyde + bs.hoyde();
		}

		System.out.println("Treet med  " + ANTALL_NODER + " noder.");

		
		System.out.println("\n\nDen minimale teoretiske høyden: " + minimaleTeoretiskeHoyden());

		System.out.println("\n\nDen maksimale teoretiske høyden: " + (ANTALL_NODER - 1));

		System.out.println("\n\nDen minste høyde i løpet av kjøringene: " + bsMinsteHoyde);

		System.out.println("\n\nDen største høyde i løpet av kjøringene: " + bsStoersteHoyde);

		System.out.println("\n\nDen gjennomsnittlig høyde av alle kjøringene: " + (bsTotaltHoyde/ANTALL_KJORINGER));

	}

	public static int minimaleTeoretiskeHoyden() {
		int n = ANTALL_NODER;
		int minimaleTeoretiskeHoyden = 0;
		while (n != 1) {
			n = n / 2;
			minimaleTeoretiskeHoyden++;
		}
		return minimaleTeoretiskeHoyden;
	}

	public static KjedetBSTre<Integer> lagNyTre() {
		Random tilfeldig = new Random();

		KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();

		for (int i = 0; i < ANTALL_NODER; i++) {
			Integer element = new Integer(tilfeldig.nextInt());
			System.out.print(element + " ");
			bs.leggTil(element);
		}
		return bs;
	}
}// class