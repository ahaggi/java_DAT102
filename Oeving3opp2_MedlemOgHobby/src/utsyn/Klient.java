package utsyn;

import java.io.IOException;

import medlem.Datakontakt;

public class Klient {
	public static void main(String[] args) throws IOException {
		
		Datakontakt dt = new Datakontakt(); 
		Meny meny = new Meny(dt);
		meny.start();
	}

}
