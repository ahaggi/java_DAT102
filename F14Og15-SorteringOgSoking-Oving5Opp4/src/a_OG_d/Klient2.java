package a_OG_d;

import java.util.Scanner;

public class Klient2 {

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		int antall;
		double tot_Tid,gjSn_Tid;
		int[][] res;

		String valg;
		String meny = "Valg sortering metode:\n" + "1-Utvalg \n" + "2-Innsetting\n" + "3-Boblesortering\n"
				+ "4-Kvikksortering\n" + "5-Flettesortering\n" + "6-sammenligne de to kvikkSortering\n" + "7-avslutt\n";

		do {
			System.out.println("\n\n" + meny);
			valg = tast.nextLine();

			switch (valg) {
			case "1":
				res = new int[3][3];
				antall= 32000;

				for (int i = 0; i <= 2; i++) {
					tot_Tid= 0;
					gjSn_Tid=0;

					res[i][0] = antall;
					res[i][1] = 3;

					for (int j = 1; j <= 3; j++) {
						tot_Tid = tot_Tid + (LagOgMaal.maalTIdUtvalg(antall));
					}

					gjSn_Tid = tot_Tid / 3;
					res[i][2] = (int) gjSn_Tid;
					antall = antall * 2;
				}
				LagOgMaal.skrivResultat("Utvalg", res);
				break;

			case "2":
				res = new int[3][3];
				antall= 32000;

				for (int i = 0; i <= 2; i++) {
					tot_Tid= 0;
					gjSn_Tid=0;

					res[i][0] = antall;
					res[i][1] = 3;

					for (int j = 1; j <= 3; j++) {
						tot_Tid = tot_Tid + (LagOgMaal.maalTIdInnsetting(antall));
					}

					gjSn_Tid = tot_Tid / 3;
					res[i][2] = (int) gjSn_Tid;
					antall = antall * 2;
				}
				LagOgMaal.skrivResultat("Innsetting", res);
				break;

			case "3":
				res = new int[3][3];
				antall= 32000;

				for (int i = 0; i <= 2; i++) {
					tot_Tid= 0;
					gjSn_Tid=0;

					res[i][0] = antall;
					res[i][1] = 3;

					for (int j = 1; j <= 3; j++) {
						tot_Tid = tot_Tid + (LagOgMaal.maalTIdBoblesortering(antall));
					}

					gjSn_Tid = tot_Tid / 3;
					res[i][2] = (int) gjSn_Tid;
					antall = antall * 2;
				}
				LagOgMaal.skrivResultat("Boblesortering", res);
				break;

			case "4":
				res = new int[3][3];
				antall= 32000;

				for (int i = 0; i <= 2; i++) {
					tot_Tid= 0;
					gjSn_Tid=0;

					res[i][0] = antall;
					res[i][1] = 3;

					for (int j = 1; j <= 3; j++) {
						tot_Tid = tot_Tid + (LagOgMaal.maalTIdKvikksortering(antall));
					}

					gjSn_Tid = tot_Tid / 3;
					res[i][2] = (int) gjSn_Tid;
					antall = antall * 2;
				}
				LagOgMaal.skrivResultat("Kvikksortering", res);
				break;

			case "5":
				res = new int[3][3];
				antall= 32000;

				for (int i = 0; i <= 2; i++) {
					tot_Tid= 0;
					gjSn_Tid=0;

					res[i][0] = antall;
					res[i][1] = 3;

					for (int j = 1; j <= 3; j++) {
						tot_Tid = tot_Tid + (LagOgMaal.maalTIdFlettesortering(antall));
					}

					gjSn_Tid = tot_Tid / 3;
					res[i][2] = (int) gjSn_Tid;
					antall = antall * 2;
				}
				LagOgMaal.skrivResultat("Flettesortering", res);
				break;
			case "6":
				res = new int[3][3];
				antall= 32000;

				for (int i = 0; i <= 2; i++) {
					tot_Tid= 0;
					gjSn_Tid=0;

					res[i][0] = antall;
					res[i][1] = 3;

					for (int j = 1; j <= 3; j++) {
						tot_Tid = tot_Tid + (LagOgMaal.maalTIdKvikksortering(antall));
					}

					gjSn_Tid = tot_Tid / 3;
					res[i][2] = (int) gjSn_Tid;
					antall = antall * 2;
				}
				LagOgMaal.skrivResultat("Den vanlig Kvikksortering", res);
				
				
				System.out.println();
				
				
				res = new int[3][3];
				antall= 32000;

				for (int i = 0; i <= 2; i++) {
					tot_Tid= 0;
					gjSn_Tid=0;

					res[i][0] = antall;
					res[i][1] = 3;

					for (int j = 1; j <= 3; j++) {
						tot_Tid = tot_Tid + (LagOgMaal.maalTIdKvikksorteringNy(antall));
					}

					gjSn_Tid = tot_Tid / 3;
					res[i][2] = (int) gjSn_Tid;
					antall = antall * 2;
				}
				LagOgMaal.skrivResultat("Den nye KvikksorteringNy", res);

				break;


			default:
				break;
			}
		} while (!valg.equals("7"));
		tast.close();

	}// main
}// class
