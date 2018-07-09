package fr.joeltroch.m2iformation.jeusimple.personnages;

/**
 * Classe qui représente un orc (normal et boss).
 * @author Joël Troch
 */
public class Orc extends Ennemi {
	/**
	 * Crée un nouvel orc en spécifiant s'il est un boss ou non.
	 * @param estBoss Est-ce un boss orc ?
	 */
	public Orc(boolean estBoss) {
		super("Orc", estBoss);
	}
}
