package fr.joeltroch.m2iformation.jeu.magie;

import fr.joeltroch.m2iformation.jeu.Configuration;
import fr.joeltroch.m2iformation.jeu.Main;
import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueIntelligence;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJEnnemi;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueDegatsMagique;

/**
 * Classe qui représente un sort de magie.
 * @author Joël Troch
 */
public abstract class MagieSort {
	/** Le nom du sort. */
	private final String nom;
	/** Les dégâts minimum du sort. */
	final int degatsMin;
	/** Les dégâts maximum du sort. */
	final int degatsMax;
	/** La quantité de mana requise pour effectuer ce sort. */
	private final int manaRequise;
	/** L'élement du sort. */
	private final MagieElements element;

	/**
	 * Crée un nouveau sort en spécifiant ses paramètres.
	 * @param nom Le nom du sort.
	 * @param degatsMin Les dégâts minimum du sort.
	 * @param degatsMax Les dégâts maximum du sort.
	 * @param manaRequise La quantité de mana requise pour effectuer ce sort.
	 * @param element L'élement du sort.
	 */
	MagieSort(String nom, int degatsMin, int degatsMax, int manaRequise, MagieElements element) {
		this.nom = nom;
		this.degatsMin = degatsMin;
		this.degatsMax = degatsMax;
		this.manaRequise = manaRequise;
		this.element = element;
	}

	public int getManaRequise() {
		return this.manaRequise;
	}

	/**
	 * Utilise le sort avec un attaquant et une victime spécifiques.
	 * @param attaquant Le personnage qui utilise le sort.
	 * @param victime La victime du sort.
	 */
	public void utiliser(Personnage attaquant, Personnage victime) {
		// Récupère la caractéristique d'intelligence
		CaracteristiqueIntelligence caracteristiqueIntelligence = null;
		for (Caracteristique caracteristique : attaquant.getListeCaracteristiques()) {
			if (caracteristique instanceof CaracteristiqueIntelligence) {
				caracteristiqueIntelligence = (CaracteristiqueIntelligence)caracteristique;
				break;
			}
		}

		if (caracteristiqueIntelligence == null) {
			caracteristiqueIntelligence = new CaracteristiqueIntelligence(10);
		}

		// Calcule les dégâts de base
		StatistiqueDegatsMagique degats = new StatistiqueDegatsMagique(Main.genererNombreAleatoire(this.degatsMin, this.degatsMax),
				caracteristiqueIntelligence);
		int resultat = degats.getValeur();

		// Si c'est un ennemi et qu'il a une faiblesse élémentaire, applique le bonus
		if (victime instanceof PersonnagePNJEnnemi) {
			if (((PersonnagePNJEnnemi)victime).getElement() != null &&
					((PersonnagePNJEnnemi)victime).getElement().estFaibleContre(this.element)) {
				resultat *= Configuration.MAGIE_ELEMENT_MULTIPLICATEUR_FAIBLESSE;
			}
		}

		// Applique les dégâts finaux
		victime.setSante(victime.getSante() - resultat);
		if (resultat < 0) {
			System.out.println("\"" + victime.toString() + "\" gagne " + resultat + " HP.");
		} else {
			System.out.println("\"" + victime.toString() + "\" perd " + resultat + " HP.");
		}
	}

	@Override
	public String toString() {
		return this.nom;
	}
}
