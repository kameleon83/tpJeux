package fr.joeltroch.m2iformation.jeusimple.personnages;

/**
 * Classe qui représente un démon (normal et boss).
 * @author Joël Troch
 */
public class Demon extends Ennemi {
	/**
	 * Crée un nouveau zombie en spécifiant s'il est un boss ou non.
	 * @param estBoss Est-ce un boss zombie ?
	 */
	public Demon(boolean estBoss) {
		super("Démon", estBoss);
	}
}
