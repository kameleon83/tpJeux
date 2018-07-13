package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui représente une boule de feu pour les feux follets.
 * @author Joël Troch
 */
public class EquipementArmeFeuFolletBouleDeFeu extends EquipementArme {
	/**
	 * Crée une nouvelle boule de feu pour les feux follets.
	 */
	public EquipementArmeFeuFolletBouleDeFeu() {
		super("Boule de feu", 3, 7, 0);
	}

	@Override
	public void appliquerBonus(Personnage attaquant, Personnage victime) {
		// Rien à faire
	}
}
