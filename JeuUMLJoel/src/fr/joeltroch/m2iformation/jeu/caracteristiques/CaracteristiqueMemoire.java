package fr.joeltroch.m2iformation.jeu.caracteristiques;

/**
 * Classe qui représente une caractéristique de mémoire.
 * @author Joël Troch
 */
public class CaracteristiqueMemoire extends Caracteristique {
	/**
	 * Crée une nouvelle caractéristique de mémoire.
	 * @param niveau Le niveau actuel de cette caractéristique de mémoire.
	 */
	public CaracteristiqueMemoire(int niveau) {
		super("Mémoire", niveau);
	}

	@Override
	public String getNomCourt() {
		return "MEM";
	}
}
