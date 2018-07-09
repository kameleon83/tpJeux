package fr.joeltroch.m2iformation.jeusimple.objets;

/**
 * Classe de base pour tous les objets.
 * @author Joël Troch
 */
public abstract class Objet {
	/** Le nom de cet objet. */
	protected String nom;
	/** Le prix d'achat de cet objet. */
	protected int prix;
	/** Le niveau requis pour utiliser cet objet. */
	protected int niveauRequis;

	/**
	 * Crée un nouvel objet en spécifiant ses paramètres.
	 * @param nom Le nom du nouvel objet.
	 * @param prix Le prix à l'achat du nouvel objet.
	 * @param niveauRequis Le niveau requis pour utiliser ce nouvel objet.
	 */
	public Objet(String nom, int prix, int niveauRequis) {
		this.nom = nom;
		this.prix = prix;
		this.niveauRequis = niveauRequis;
	}
}
