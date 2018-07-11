package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui représente une épée.
 * @author Joël Troch
 */
public class EquipementArmeEpeeDoubleTranchant extends EquipementArme {
	/**
	 * Crée une nouvelle épée.
	 */
	public EquipementArmeEpeeDoubleTranchant() {
		super("Epée à double tranchant", 10, 15, 125);
	}

	@Override
	public void appliquerBonus(Personnage attaquant, Personnage victime) {
		victime.setSante(victime.getSante() - 2);
		System.out.println("L'épée à double tranchant de \"" + attaquant.toString() + "\" lui retire 2 HP !");
	}
}
