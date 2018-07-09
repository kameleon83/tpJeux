package fr.joeltroch.m2iformation.jeusimple.objets;

/**
 * Classe de base pour tous les équipements.
 * @author Joël Troch
 */
public class Equipement extends Objet {
	/**
	 * Crée un nouvel équipement en spécifiant ses paramètres
	 * @param nom Le nom de ce nouvel équipement.
	 * @param prix Le prix à l'achat de ce nouvel équipement.
	 * @param niveauRequis Le niveau requis pour utiliser ce nouvel équipement.
	 */
	public Equipement(String nom, int prix, int niveauRequis) {
		super(nom, prix, niveauRequis);
	}
}
