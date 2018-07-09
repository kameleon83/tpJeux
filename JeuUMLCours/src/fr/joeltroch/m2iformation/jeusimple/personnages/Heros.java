package fr.joeltroch.m2iformation.jeusimple.personnages;

import fr.joeltroch.m2iformation.jeusimple.objets.Objet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de base pour tous les héros.
 * @author Joël Troch
 */
public abstract class Heros extends Personnage {
	/** La quantité d'argent que possède actuellement cet héros. */
	protected int argent;
	/** La liste des objets que possède actuellement cet héros. */
	protected List<Objet> listeObjets = new ArrayList<>();

	/**
	 * Crée un nouvel héros en spécifiant son nom.
	 * @param nom Le nom de l'héros.
	 */
	public Heros(String nom) {
		super(nom);
	}
}
