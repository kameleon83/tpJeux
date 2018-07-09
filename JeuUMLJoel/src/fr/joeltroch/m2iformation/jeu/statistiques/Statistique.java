package fr.joeltroch.m2iformation.jeu.statistiques;

/**
 * Classe de base pour toutes les statistiques.
 * @author Joël Troch
 */
public abstract class Statistique {
	/**
	 * Retourne la valeur finale de cette statistique, c'est à dire après avoir pris en compte tous les modificateurs.
	 * @return La valeur finale de cette statistique.
	 */
	public abstract int getValeur();

	@Override
	public abstract String toString();
}
