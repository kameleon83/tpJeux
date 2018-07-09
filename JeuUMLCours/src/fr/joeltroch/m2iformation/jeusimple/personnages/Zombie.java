package fr.joeltroch.m2iformation.jeusimple.personnages;

/**
 * Classe qui représente un démon (normal et boss).
 * @author Joël Troch
 */
public class Zombie extends Ennemi {
	/**
	 * Crée un nouveau démon en spécifiant s'il est un boss ou non.
	 * @param estBoss Est-ce un boss démon ?
	 */
	public Zombie(boolean estBoss) {
		super("Zombie", estBoss);
	}
}
