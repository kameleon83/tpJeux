package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui représente une potion de mana.
 * @author Joël Troch
 */
public class EquipementObjetPotionMana extends EquipementObjet {
	/**
	 * Crée une nouvelle potion de mana.
	 */
	public EquipementObjetPotionMana() {
		super("Potion de mana", 50);
	}

	@Override
	public void utiliser(Personnage attaquant, Personnage victime) {
		// Affiche le message
		super.utiliser(attaquant, victime);

		// Ne dépasse pas la mana max.
		int manaMaxVictime = victime.getManaMax();
		int mana = victime.getMana() + App.genererNombreAleatoire(30, 35);
		if (mana > manaMaxVictime) {
			mana = manaMaxVictime - victime.getMana();
		}
		victime.setMana(mana);

		// Résultat
		if (attaquant == victime) {
			System.out.println("La potion de \"" + attaquant.toString() + "\" lui a donné " + mana + " MP.");
		} else {
			System.out.println("La potion de \"" + attaquant.toString() + "\" a donné " + mana + " MP à \"" + victime.toString() + "\".");
		}
	}
}
