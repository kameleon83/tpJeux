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
	public Caracteristique(String nom, int niveau) {
		this.nom = nom;
		this.niveau = niveau;
	}

	/**
	 * Incrémente de 1 le niveau actuel de cette caractéristique sous condition qu'elle ne dépasserait pas le niveau maximum.
	 * @return <code>true</code> si le niveau a été incrémenté, <code>false</code> dans le cas contraire.
	 */
	public boolean augmenterNiveau() {
		if (this.niveau + 1 > Configuration.CARACTERISTIQUE_NIVEAU_MAX) {
			System.out.println("Niveau maximal déjà atteint !");
			return false;
		}

		this.niveau++;
		return true;
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
