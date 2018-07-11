package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.Main;
import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueForce;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueDegatsPhysique;

/**
 * Classe de base pour toutes les armes physiques.
 * @author Joël Troch
 */
public abstract class EquipementArme extends Equipement {
	/** Dégâts minimum de l'arme. */
	private final int degatsMin;
	/** Dégâts maximum de l'arme. */
	private final int degatsMax;

	/**
	 * Crée une nouvelle arme de base avec ses paramètres spécifiques.
	 * @param nom Nom de l'arme.
	 * @param degatsMin Dégâts minimum de l'arme.
	 * @param degatsMax Dégâts maximum de l'arme.
	 * @param prix Prix à l'achat de l'arme.
	 */
	EquipementArme(String nom, int degatsMin, int degatsMax, int prix) {
		super(nom, prix);
		this.degatsMin = degatsMin;
		this.degatsMax = degatsMax;
	}

	public int getMoyenneDegats() {
		return (this.degatsMin + this.degatsMax) / 2;
	}

	/**
	 * Applique les bonus post-attaque de cette arme (si elle en possède).
	 * @param attaquant L'attaquant qui a fait l'attaque.
	 * @param victime La victime qui a subi l'attaque.
	 */
	public abstract void appliquerBonus(Personnage attaquant, Personnage victime);

	/**
	 * Utilise cette arme avec un attaquant et une victime spécifiques.
	 * @param attaquant Le personnage qui utilise l'arme.
	 * @param victime La victime qui subit les dégâts de l'arme.
	 */
	public void attaquer(Personnage attaquant, Personnage victime) {
		// Récupère la caractéristique force de l'attaquant
		CaracteristiqueForce caracteristiqueForce = null;
		for (Caracteristique caracteristique : attaquant.getListeCaracteristiques()) {
			if (caracteristique instanceof CaracteristiqueForce) {
				caracteristiqueForce = (CaracteristiqueForce)caracteristique;
				break;
			}
		}

		// On ne sait jamais
		if (caracteristiqueForce == null) {
			caracteristiqueForce = new CaracteristiqueForce(3);
		}

		// Applique les dégâts et affiche le résultat
		StatistiqueDegatsPhysique degats = new StatistiqueDegatsPhysique(Main.genererNombreAleatoire(this.degatsMin, this.degatsMax),
				caracteristiqueForce);
		int resultat = degats.getValeur();
		victime.setSante(victime.getSante() - resultat);
		System.out.println("\"" + victime.toString() + "\" perd " + resultat + " HP.");
	}
}
