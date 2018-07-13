package fr.joeltroch.m2iformation.jeu;

/**
 * Classe qui contient des constantes et fait office de "configuration" pour le jeu.
 * @author Joël Troch
 */
public abstract class Configuration {
	/** Le niveau maximum pour les caractéristiques. */
	public static final int CARACTERISTIQUE_NIVEAU_MAX = 15;

	/** Le niveau de départ pour les compétences du joueur. */
	public static final int JOUEUR_DEPART_NIVEAU_CARACTERISTIQUES = 1;

	/** La quantité de pièces d'or du joueur au début de la partie. */
	public static final int JOUEUR_DEPART_QUANTITE_PIECES_OR = 200;

	/** La quantité de points de compétences à dépenser par le joueur au début de la partie. */
	public static final int JOUEUR_DEPART_QUANTITE_POINTS_CARACTERISTIQUES = 14;

	/** La quantité de base de points d'expérience que le joueur doit obtenir pour passer au niveau supérieur. */
	public static final int JOUEUR_EXPERIENCE_PAR_NIVEAU = 100;

	/** La quantité de points de compétences gagnée à chaque passage de niveau. */
	public static final int JOUEUR_NIVEAU_SUP_QUANTITE_POINTS_CARACTERISTIQUES = 3;

	/** Le multiplicateur de "coup critique" avec les dégâts de magie. */
	public static final float MAGIE_ELEMENT_MULTIPLICATEUR_FAIBLESSE = 1.5f;
}
