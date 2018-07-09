package fr.joeltroch.m2iformation.jeusimple.objets;

/**
 * Classe qui représente une potion.
 * @author Joël Troch
 */
public class Potion extends Objet {
	/**
	 * Crée une nouvelle potion en spécifiant ses paramètres.
	 * @param nom Le nom de la nouvelle potion.
	 * @param prix Le prix de la nouvelle potion.
	 * @param niveauRequis Le niveau requis pour utiliser cette nouvelle potion.
	 */
	public Potion(String nom, int prix, int niveauRequis) {
		super(nom, prix, niveauRequis);
	}
}
