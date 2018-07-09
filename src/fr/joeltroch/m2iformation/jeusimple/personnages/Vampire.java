package fr.joeltroch.m2iformation.jeusimple.personnages;

/**
 * Classe qui représente un vampire (normal et boss).
 * @author Joël Troch
 */
public class Vampire extends Ennemi {
	/**
	 * Crée un nouveau vampire en spécifiant s'il est un boss ou non.
	 * @param estBoss Est-ce un boss vampire ?
	 */
	public Vampire(boolean estBoss) {
		super("Vampire", estBoss);
	}
}
