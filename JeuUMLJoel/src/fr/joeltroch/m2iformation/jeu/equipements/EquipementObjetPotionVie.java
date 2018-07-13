package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui représente une potion de vie.
 * @author Joël Troch
 */
public class EquipementObjetPotionVie extends EquipementObjet {
	/**
	 * Crée une nouvelle potion de vie.
	 */
	public EquipementObjetPotionVie() {
		super("Potion de soins", 40);
	}

	@Override
	public void utiliser(Personnage attaquant, Personnage victime) {
		// Affiche le message
		super.utiliser(attaquant, victime);

		// Ne dépasse pas la santé max.
		int santeMaxVictime = victime.getSanteMax();
		int soins = victime.getSante() + App.genererNombreAleatoire(30, 35);
		if (soins > santeMaxVictime) {
			soins = santeMaxVictime - victime.getSante();
		}
		victime.setSante(soins);

		// Résultat
		if (attaquant == victime) {
			System.out.println("La potion de \"" + attaquant.toString() + "\" lui a donné " + soins + " HP.");
		} else {
			System.out.println("La potion de \"" + attaquant.toString() + "\" a donné " + soins + " HP à \"" + victime.toString() + "\".");
		}
	}
}
