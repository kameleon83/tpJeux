package fr.joeltroch.m2iformation.jeu.personnages;

import java.util.List;

/**
 * Classe de base pour tous les personnages non contrôlable ami.
 * @author Joël Troch
 */
public abstract class PersonnagePNJAmi extends PersonnagePNJ {
	/**
	 * Crée un personnage non contrôlable amical avec un nom spécifique.
	 * @param nom Le nom du personnage non contrôlable.
	 */
	PersonnagePNJAmi(String nom) {
		super(nom);
	}

	@Override
	public void effectuerAction(List<Personnage> personnages) {
		// Rien à faire
	}

	/**
	 * Permet à un joueur spécifique de parler à ce personnage non contrôlable amical.
	 * @param joueur Le joueur qui parle à ce personnage non contrôlable.
	 */
	public abstract void parler(PersonnageJoueur joueur);
}
