package fr.joeltroch.m2iformation.jeu.personnages;

import fr.joeltroch.m2iformation.jeu.magie.MagieElements;

/**
 * Classe qui représente un personnage non contrôlable ennemi.
 * @author Joël Troch
 */
public abstract class PersonnagePNJEnnemi extends PersonnagePNJ {
	/** Cet ennemi est un boss ? */
	private final boolean estBoss;
	/** L'élement magique de cet ennemi, utilisé pour la faiblesse (null = aucun). */
	private final MagieElements element;

	/**
	 * Crée un nouveau personnage non contrôlable ennemi avec ses paramètres.
	 * @param nom Le nom de cet ennemi.
	 * @param estBoss Est-ce un boss ou ennemi classique ?
	 * @param element L'élément magique de cet ennemi (null si aucun).
	 */
	PersonnagePNJEnnemi(String nom, boolean estBoss, MagieElements element) {
		super(nom);
		this.estBoss = estBoss;
		this.element = element;
	}

	public MagieElements getElement() {
		return this.element;
	}

	@Override
	public String toString() {
		if (estBoss) {
			return "[BOSS] " + super.toString();
		}

		return super.toString();
	}
}
