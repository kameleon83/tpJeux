package fr.joeltroch.m2iformation.jeu.personnages;

/**
 * Classe de base pour tous les personnages non contrôlables.
 * @author Joël Troch
 */
abstract class PersonnagePNJ extends Personnage {
	/**
	 * Crée un personnage non contrôlable avec un nom spécifique.
	 * @param nom Le nom du personnage non contrôlable.
	 */
	PersonnagePNJ(String nom) {
		super(nom);
	}
}
