package fr.joeltroch.m2iformation.jeusimple.personnages;

/**
 * Classe de base pour tous les ennemis.
 * @author Joël Troch
 */
public abstract class Ennemi extends Personnage {
	/** Cet ennemi est un boss ou un ennemi classique ? */
	protected boolean estBoss;

	/**
	 * Crée un nouvel ennemi en spécifiant s'il est un boss ou non.
	 * @param nom Le nom de l'ennemi.
	 * @param estBoss Est-ce un boss ou non ?
	 */
	public Ennemi(String nom, boolean estBoss) {
		super(nom);
		this.estBoss = estBoss;
	}
}
