package jeu;

public class JeuFactory {

	public static String randomMain() {
		String mainOrdinateur = null;
		
		// Random pour déterminer la main de l'ordinateur
		int higher = 3;
		int lower = 1;
		int choix = (int)(java.lang.Math.random() * (higher+1-lower)) + lower;

		if (choix == 1) {
			mainOrdinateur = "pierre";
		} else if (choix == 2) {
			mainOrdinateur = "papier";
		} else if (choix == 3) {
			mainOrdinateur = "ciseaux";
		}
		
		return mainOrdinateur;
	}
}
