package jeu.data;

public class Resultat {
	
	private int nombreVictoire=0;
	private int nombreEgalite=0;
	private int nombreDefaite=0;

	public int getNombreVictoire() {
		return nombreVictoire;
	}

	public void setNombreVictoire(int nombreVictoire) {
		this.nombreVictoire = nombreVictoire;
	}
	
	public int getNombreEgalite() {
		return nombreEgalite;
	}

	public void setNombreEgalite(int nombreEgalite) {
		this.nombreEgalite = nombreEgalite;
	}

	public int getNombreDefaite() {
		return nombreDefaite;
	}

	public void setNombreDefaite(int nombreDefaite) {
		this.nombreDefaite = nombreDefaite;
	}
	

	//////////////////////////////////
	public void addGagne() {
		nombreVictoire++;
	}
	
	public void addPerdu() {
		nombreDefaite++;
	}
	
	public void addEgalite() {
		nombreEgalite++;
	}
}
