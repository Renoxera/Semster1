package Aufgabe2AufgabenVerwaltung;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AufgabenVerwaltung {
	ArrayList<Aufgabe> alleAufgaben, erledigteAufgaben, unerledigteAufgaben;
	
	public AufgabenVerwaltung() {
		alleAufgaben = new ArrayList<Aufgabe>();
		erledigteAufgaben = new ArrayList<Aufgabe>();
		unerledigteAufgaben = new ArrayList<Aufgabe>();
	}
	
	/**
	 * @param name
	 * @param erledigt
	 * @param datum    Form: dd.mm.yyyy, hh:mm
	 * @return
	 */
	public Aufgabe erzeugeAufgabe(String name, boolean erledigt, String datum) {
		
		GregorianCalendar faelligkeitsdatum = stringToDatum(datum);
		return new Aufgabe(name, erledigt, faelligkeitsdatum);
	}
	
	public GregorianCalendar stringToDatum(String datum) {
		datum = datum.replaceAll("[^0-9,.:]", "");
		if (datum.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{1,4}[,][0-9]{1,2}[:][0-9]{1,2}")) {
			String date = datum.split(",")[0];
			String time = datum.split(",")[1];
			
			String[] dateA = date.split("[.]");
			String[] timeA = time.split("[:]");
			
			int tag = Integer.parseInt(dateA[0]);
			int monat = Integer.parseInt(dateA[1]);
			int jahr = Integer.parseInt(dateA[2]);
			int stunde = Integer.parseInt(timeA[0]);
			int minute = Integer.parseInt(timeA[1]);
			if (pruefeValiedenTag(tag, monat, jahr) && (stunde >= 0 && stunde < 24) && (minute >= 0 && minute < 60)) {
				GregorianCalendar d = new GregorianCalendar(jahr, monat-1, tag, stunde, minute);
				return d;
			}
		}
		System.out.println("Fehler in " + datum);
		
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean pruefeValiedenTag(int tag, int monat, int jahr) {
		return (jahr >= 0) && (tag > 0)
				&& (((monat > 0 && monat <= 7) && (((monat == 2 && jahr % 4 == 0) && (tag <= 29))
						|| ((monat == 2 && jahr % 4 != 0) && (tag <= 28)) || ((monat % 2 == 1) && (tag <= 31))
						|| ((monat != 2 && monat % 2 == 0) && (tag <= 30))))
						|| ((monat > 7 && monat <= 12)
								&& (((monat % 2 == 0) && (tag <= 31)) || ((monat % 2 == 1) && (tag <= 30)))));
		
	}
	
	public void fuegeAufgabeHinzu(Aufgabe aufgabe) {
		alleAufgaben.add(aufgabe);
		if (aufgabe.istErledigt()) {
			erledigteAufgaben.add(aufgabe);
		} else {
			unerledigteAufgaben.add(aufgabe);
		}
	}
	
	class Aufgabe {
		private boolean				erledigt	= false;
		private String				aufgabe;
		private GregorianCalendar	faelligkeitsdatum;
		
		public Aufgabe(String name, boolean erledigt, GregorianCalendar datum) {
			this.aufgabe = name;
			this.erledigt = erledigt;
			this.faelligkeitsdatum = datum;
		}
		
		public boolean istErledigt() {
			return erledigt;
		}
	}
}
