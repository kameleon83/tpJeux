package fr.joeltroch.m2iformation.jeu.statistiques;

/**
 * Classe de base pour tous les dégâts.
 * @author Joël Troch
 */
public abstract class StatistiqueDegats extends Statistique {
	/** Quantité de dégâts de base. */
	final int degats;

	/**
	 * Crée une statistique dégâts de base.
	 * @param degats La quantité de dégâts de base.
	 */
	public StatistiqueDegats(int degats) {
		this.degats = degats;
	}
}
