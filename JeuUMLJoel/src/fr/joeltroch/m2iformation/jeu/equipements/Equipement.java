package fr.joeltroch.m2iformation.jeu.equipements;

/**
 * Classe qui sert de base pour tous les équipements.
 * @author Joël Troch
 */
public abstract class Equipement {
	/** Nom de cet équipement. */
	final String nom;
	/** Prix de cet équipement. */
	private final int prix;

	/**
	 * Crée un équipement avec un nom spécifique.
	 * @param nom Le nom de l'équipement.
	 * @param prix Le prix de l'équipement.
	 */
	Equipement(String nom, int prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public int getPrix() {
		return this.prix;
	}

	@Override
	public String toString() {
		return this.nom;
	}
}
