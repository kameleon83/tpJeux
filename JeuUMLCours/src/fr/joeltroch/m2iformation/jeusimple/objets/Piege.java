package fr.joeltroch.m2iformation.jeusimple.objets;

/**
 * Classe qui représente un piège.
 * @author Joël Troch
 */
public class Piege extends Objet {
	/**
	 * Crée un nouveau piège en spécifiant ses paramètres.
	 * @param nom Le nom du nouveau piège.
	 * @param prix Le prix du nouveau piège.
	 * @param niveauRequis Le niveau requis pour utiliser ce nouveau piège.
	 */
	public Piege(String nom, int prix, int niveauRequis) {
		super(nom, prix, niveauRequis);
	}
}
