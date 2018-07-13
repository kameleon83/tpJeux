package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui représente une épée.
 * @author Joël Troch
 */
public class EquipementArmeEpee extends EquipementArme {
	/**
	 * Crée une nouvelle épée.
	 */
	public EquipementArmeEpee() {
		super("Epée", 10, 15, 100);
	}

	@Override
	public void appliquerBonus(Personnage attaquant, Personnage victime) {
		// Rien à faire
	}
}
