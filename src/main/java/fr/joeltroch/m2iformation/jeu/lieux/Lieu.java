package fr.joeltroch.m2iformation.jeu.lieux;

import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

/**
 * Classe de base pour tous les lieux.
 * @author Joël Troch
 */
public abstract class Lieu {
	/** Nom du lieu. */
	final String nom;

	/**
	 * Crée un nouveau lieu avec un nom particulier.
	 * @param nom Nom du nouveau lieu.
	 */
	Lieu(String nom) {
		this.nom = nom;
	}

	/**
	 * Ordonne à un joueur spécifique de parcourir ce lieu.
	 * @param joueur Le joueur en question.
	 */
	public abstract void parcourir(PersonnageJoueur joueur);

	@Override
	public String toString() {
		return this.nom;
	}
}
