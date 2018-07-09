package fr.joeltroch.m2iformation.jeu.caracteristiques;

/**
 * Classe qui représente une caractéristique d'intelligence.
 * @author Joël Troch
 */
public class CaracteristiqueIntelligence extends Caracteristique {
	/**
	 * Crée une nouvelle caractéristique d'intelligence.
	 * @param niveau Le niveau actuel de cette caractéristique d'intelligence.
	 */
	public CaracteristiqueIntelligence(int niveau) {
		super("Intelligence", niveau);
	}

	@Override
	public String getNomCourt() {
		return "INT";
	}
}
