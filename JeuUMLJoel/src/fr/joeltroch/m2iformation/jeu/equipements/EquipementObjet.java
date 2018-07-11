package fr.joeltroch.m2iformation.jeu.equipements;

import fr.joeltroch.m2iformation.jeu.personnages.Personnage;

/**
 * Classe qui sert de base à tous les objets utilisables.
 * @author Joël Troch
 */
public abstract class EquipementObjet extends Equipement {
	/**
	 * Crée un nouvel objet utilisable avec un nom spécifique.
	 * @param nom Le nom de l'objet utilisable.
	 * @param prix Le prix de l'objet utilisable.
	 */
	EquipementObjet(String nom, int prix) {
		super(nom, prix);
	}

	/**
	 * Utilise cet objet avec un utilisateur et une victime spécifiques.
	 * @param attaquant Le personnage qui utilise l'objet.
	 * @param victime Le personnage qui va subir les effets de l'objet.
	 */
	public void utiliser(Personnage attaquant, Personnage victime) {
		if (attaquant == victime) {
			System.out.println("\"" + attaquant.toString() + "\" utilise l'objet \"" + this.nom + "\" sur lui(elle)-même.");
		} else {
			System.out.println("\"" + attaquant.toString() + "\" utilise l'objet \"" + this.nom + "\" sur \"" + victime.toString() + "\"");
		}
	}
}
