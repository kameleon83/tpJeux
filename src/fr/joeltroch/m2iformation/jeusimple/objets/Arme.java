package fr.joeltroch.m2iformation.jeusimple.objets;

/**
 * Classe de base pour toutes les armes.
 * @author Joël Troch
 */
public class Arme extends Objet {
	/**
	 * Crée une nouvelle arme en spécifiant ses paramètres.
	 * @param nom Le nom de cette nouvelle arme.
	 * @param prix Le prix à l'achat de cette nouvelle arme.
	 * @param niveauRequis Le niveau requis pour utiliser cette arme.
	 */
	public Arme(String nom, int prix, int niveauRequis) {
		super(nom, prix, niveauRequis);
	}
}
