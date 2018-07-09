package fr.joeltroch.m2iformation.jeusimple.personnages;

/**
 * Classe qui représente une sorcière (normal et boss).
 * @author Joël Troch
 */
public class Sorciere extends Ennemi {
	/**
	 * Crée une nouvelle sorcière en spécifiant s'il est un boss ou non.
	 * @param estBoss Est-ce un boss sorcière ?
	 */
	public Sorciere(boolean estBoss) {
		super("Sorcière", estBoss);
	}
}
