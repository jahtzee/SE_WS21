package Übung;

/*
File: Bestellung.java
Author: Felix Mayer
E-Mail: felix.mayer@hs-kl.de
Last Change: 15.12.2021

Diese Datei repräsentiert den Ablauf einer online Bestellung gemäß des Zustandsdiagramms aus Übung 1 von Aufgabenblatt "Vorlesung SE WS 21/22 Übungsblatt 9".
*/

public class Bestellung {
	
	//Dieses Enum repräsentiert alle möglichen Zustände, die die Bestellung annehmen kann
	private enum Zustand {
			BESTELLUNG_IN_BEARBEITUNG, 
			ADRESSDATEN_IN_PRÜFUNG, 
			// ToDo: weitere Einträge für die restlichen Zustände...
	}
	
	public Zustand zustandsvariable=Zustand.BESTELLUNG_IN_BEARBEITUNG; // die Zustandsvariable zur Verwaltung des Zustands der Bestellung
	public int lagerbestand; // die Höhe des Lagebestand hat Auswirkungen auf den Ablauf, weshalb dieser explizit als Attribut mitaufgeführt wird
	
	// Transition von Zustand "???" zu dem Zustand "Bestellung bearbeitet"
	public void bestellungBearbeiten() {
		switch(zustandsvariable) {
		case ???: // ergänzt den Zustand im obigen Kommnetar
			System.out.println("Bestellung wird bearbeitet");
			break;
		default:
			System.out.println("Keine gültige Transition");
		}
	}
	
	// Transition von Zustand "Bestellung bearbeitet" zu dem Zustand "Überprüfung der Adressdaten"
	public void überprüfeAdressdaten() {
		switch(zustandsvariable) {
		case BESTELLUNG_IN_BEARBEITUNG:
			System.out.println("Adressdaten werden überprüft");
			zustandsvariable=Zustand.ADRESSDATEN_IN_PRÜFUNG;
			break;
		default:
			System.out.println("Keine gültige Transition");
		}
	}
	
	public void überprüfeLagerbestand() {
		System.out.println("Lagerbestand wird überprüft");
	}
	
	public void auswertenDesLagerbestands() {
		// Fall für ein leeres Lager
		System.out.println("Produkt derzeit nicht auf Lager");
		// Fall für ein gefülltes Lager
		System.out.println("Bestätigung der Bestellung");
	}
	
	public void bereiteVersandVor() {
		System.out.println("Versand wird vorbereitet");
	}
	
	public void liefereAnRechnungsadresse() {
		System.out.println("Versand erfolgt an Rechnungsadresse");
	}
	
	public void liefereAnPostfach() {
		System.out.println("Versand erfolgt an Postfach");
	}

	/*
	 * Die Main Methode zum Testen der korrekten Funktionsweise der Transitionen.
	 * Erwartete Ausgabe:
	 * Bestellung wird bearbeitet
	 * Adressdaten werden überprüft
	 * Bestellung wird bearbeitet
	 * Adressdaten werden überprüft
	 * Lagerbestand wird überprüft
	 * Bestätigung der Bestellung
	 * Versand wird vorbereitet
	 * Keine gültige Transition
	 * Versand erfolgt an Postfach
	 */
	public static void main(String[] args) {
		Bestellung b = new Bestellung();
		b.lagerbestand=10;
		
		b.bestellungBearbeiten();
		b.überprüfeAdressdaten();
		b.bestellungBearbeiten();
		b.überprüfeAdressdaten();
		b.überprüfeLagerbestand();
		b.auswertenDesLagerbestands();
		b.bereiteVersandVor();
		b.bestellungBearbeiten();
		b.liefereAnPostfach();
	}
}
