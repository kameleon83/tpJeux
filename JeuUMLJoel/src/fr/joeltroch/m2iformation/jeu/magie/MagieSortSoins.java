package fr.joeltroch.m2iformation.jeu.magie;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueIntelligence;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueDegatsMagique;

/**
 * Classe qui représente le sort "Soins".
 * @author Joël Troch
 */
public class MagieSortSoins extends MagieSort {
	/** Crée le sort "Soins" avec ses paramètres par défaut. */
	public MagieSortSoins() {
		super("Soins", 30, 35, 5, null);
	}

	@Override
	public void utiliser(Personnage attaquant, Personnage victime) {
		// Récupère la caractéristique d'intelligence
		CaracteristiqueIntelligence caracteristiqueIntelligence = null;
		for (Caracteristique caracteristique : attaquant.getListeCaracteristiques()) {
			if (caracteristique instanceof CaracteristiqueIntelligence) {
				caracteristiqueIntelligence = (CaracteristiqueIntelligence)caracteristique;
				break;
			}
		}

		// On ne sait jamais
		if (caracteristiqueIntelligence == null) {
			caracteristiqueIntelligence = new CaracteristiqueIntelligence(10);
		}

		// Calcule les "dégâts" de base (technique de développement classique dans les jeux vidéos)
		StatistiqueDegatsMagique degats = new StatistiqueDegatsMagique(App.genererNombreAleatoire(this.degatsMin, this.degatsMax),
				caracteristiqueIntelligence);
		int resultat = degats.getValeur();

		// Applique les "dégâts" (soins) finaux
		final int ancienneVie = victime.getSante();
		victime.setSante(victime.getSante() + resultat);
		System.out.println("\"" + victime.toString() + "\" gagne " + (victime.getSante() - ancienneVie) + " HP.");
	}
}
