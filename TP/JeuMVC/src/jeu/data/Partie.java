package jeu.data;

public class Partie {

	private String mainJoueur;
	private String mainOrdinateur;
	
	public Partie() {
		initMainOrdinateur();
	}
	
	public String getMainJoueur() {
		return mainJoueur;
	}

	public void setMainJoueur(String mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	public String getMainOrdinateur() {
		return mainOrdinateur;
	}
	
	public void setMainOrdinateur(String mainOrdinateur) {
		this.mainOrdinateur = mainOrdinateur;
	}

	//////////////////////////////////
	private void initMainOrdinateur() {
		int higher = 3;
		int lower = 1;
		int choix = (int)(java.lang.Math.random() * (higher+1-lower)) + lower;
		
		if (choix == 1) {
			mainOrdinateur = "pierre";
		} else if (choix == 2) {
			mainOrdinateur = "papier";
		} else if (choix == 3) {
			mainOrdinateur = "ciseaux";
		} else {
			System.out.println("oups");
		}
	}
	
	//////////////////////////////////
	public boolean egalite() {
		return mainJoueur.equals(mainOrdinateur);
	}
	
	public boolean joueurGagne() {
		return (mainJoueur.equals("pierre") && mainOrdinateur.equals("ciseaux"))
				|| (mainJoueur.equals("ciseaux") && mainOrdinateur.equals("papier"))
				|| (mainJoueur.equals("papier") && mainOrdinateur.equals("pierre"));
	}
	

}
