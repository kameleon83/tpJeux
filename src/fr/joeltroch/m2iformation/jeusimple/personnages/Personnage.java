package fr.joeltroch.m2iformation.jeusimple.personnages;

import fr.joeltroch.m2iformation.jeusimple.sorts.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de base pour tous les personnages.
 * @author Joël Troch
 */
public abstract class Personnage {
	/** La quantité de "Vitalité" actuelle de ce personnage. */
	protected int vitalite;
	/** La quantité de "Force" actuelle de ce personnage. */
	protected int force;
	/** La quantité "d'Intelligence" actuelle de ce personnage. */
	protected int intelligence;
	/** La quantité de "Mémoire" actuelle de ce personnage. */
	protected int memoire;

	/** L'expérience actuel de ce personnage. */
	protected int experience;
	/** Le niveau actuel de ce personnage. */
	protected int niveau;
	/** La santé actuelle de ce personnage. */
	protected int sante;
	/** La mana actuelle de ce personnage. */
	protected int mana;

	/** La liste des sorts que possède ce personnage. */
	protected List<Sort> listeSorts = new ArrayList<>();

	/** Le nom de ce personnage. */
	protected String nom;

	/**
	 * Ordonne à ce personnage d'attaquer un autre personnage.
	 * @param personnage Le personnage à cibler.
	 */
	public void attaquer(Personnage personnage) {
		// TODO
	}

	/**
	 * Ordonne à ce personnage d'utiliser un sort spécifique.
	 * @param sort Le sort à utiliser.
	 */
	public void utiliserSort(Sort sort) {
		// TODO
	}

	/** Ordonne à ce personnage de fuir. */
	public void fuir() {
		// TODO
	}

	/**
	 * Crée un nouveau personnage en spécifiant son nom.
	 * @param nom Le nom du personnage.
	 */
	public Personnage(String nom) {
		this.nom = nom;
	}
}
