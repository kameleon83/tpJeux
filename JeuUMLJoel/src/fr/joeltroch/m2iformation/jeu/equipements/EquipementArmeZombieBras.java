package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui représente des bras de zombie.
 * @author Joël Troch
 */
public class EquipementArmeZombieBras extends EquipementArme {
	/**
	 * Crée une nouvelle paire de bras de zombie.
	 */
	public EquipementArmeZombieBras() {
		super("Bras de zombie", 2, 5, 0);
	}

	@Override
	public void appliquerBonus(Personnage attaquant, Personnage victime) {
		// Rien à faire
	}
}
