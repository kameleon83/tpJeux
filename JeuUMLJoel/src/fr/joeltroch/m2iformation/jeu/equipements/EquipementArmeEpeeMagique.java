package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui représente une épée.
 * @author Joël Troch
 */
public class EquipementArmeEpeeMagique extends EquipementArme {
	/**
	 * Crée une nouvelle épée.
	 */
	public EquipementArmeEpeeMagique() {
		super("Epée Magique", 10, 15, 150);
	}

	@Override
	public void appliquerBonus(Personnage attaquant, Personnage victime) {
		if (attaquant.getSante() < attaquant.getSanteMax()) {
			final int ancienneSante = attaquant.getSante();
			final int santeMax = attaquant.getSanteMax();

			int soins = attaquant.getSante() + 10;
			if (soins >= santeMax) {
				soins = santeMax;
			}

			attaquant.setSante(soins);
			System.out.println("L'épée magique de \"" + attaquant.toString() + "\" lui donne " + (soins - ancienneSante) + " HP !");
		}
	}
}
