package fr.joeltroch.m2iformation.jeu.caracteristiques;

/**
 * Classe qui représente une caractéristique de vitalité.
 * @author Joël Troch
 */
public class CaracteristiqueVitalite extends Caracteristique {
	/**
	 * Crée une nouvelle caractéristique de vitalité.
	 * @param niveau Le niveau actuel de cette caractéristique de vitalité.
	 */
	public CaracteristiqueVitalite(int niveau) {
		super("Vitalité", niveau);
	}

	@Override
	public String getNomCourt() {
		return "VIT";
	}
}
