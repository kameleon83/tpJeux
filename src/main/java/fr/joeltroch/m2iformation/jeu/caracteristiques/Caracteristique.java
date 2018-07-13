package fr.joeltroch.m2iformation.jeu.caracteristiques;

import fr.joeltroch.m2iformation.jeu.Configuration;

/**
 * Classe de base pour toutes les caractéristiques.
 * @author Joël Troch
 */
public abstract class Caracteristique {
	/** Le nom de la caractéristique. */
	private final String nom;

	/** Le niveau actuel de cette caractéristique. */
	private int niveau;

	/**
	 * Crée une nouvelle caractéristique en spécifiant son nom et son niveau actuel.
	 * @param nom Le nom de cette nouvelle caractéristique.
	 * @param niveau Le niveau actuel de cette nouvelle caractéristique.
	 */
	Caracteristique(String nom, int niveau) {
		this.nom = nom;
		this.niveau = niveau;
	}

	/**
	 * Ajoute une certaine quantité de niveaux.
	 * @param niveaux La quantité de niveaux à rajouter.
	 */
	public void addNiveau(int niveaux) {
		if (this.niveau + niveaux > Configuration.CARACTERISTIQUE_NIVEAU_MAX) {
			this.niveau = Configuration.CARACTERISTIQUE_NIVEAU_MAX;
		} else {
			this.niveau += niveaux;
		}
	}

	public int getNiveau() {
		return this.niveau;
	}

	/**
	 * Retourne le nom court (ou une abbréviation) de cette caractéristique.
	 * @return Une abbréviation du nom de cette caractéristique.
	 */
	public abstract String getNomCourt();

	@Override
	public String toString() {
		return this.nom;
	}
}
