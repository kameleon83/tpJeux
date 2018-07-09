package fr.joeltroch.m2iformation.jeusimple.lieux;

import fr.joeltroch.m2iformation.jeusimple.personnages.Personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de base pour tous les lieux.
 * @author Joël Troch
 */
public abstract class Lieu {
	/** Le nom de ce lieu. */
	protected String nom;

	/** La liste des personnages dans ce lieu. */
	protected List<Personnage> listePersonnages = new ArrayList<>();

	/**
	 * Crée un nouveau lieu en spécifiant son nom.
	 * @param nom Le nom du nouveau lieu.
	 */
	public Lieu(String nom) {
		this.nom = nom;
	}
}
