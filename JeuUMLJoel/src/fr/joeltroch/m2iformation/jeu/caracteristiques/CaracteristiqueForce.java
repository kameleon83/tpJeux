package fr.joeltroch.m2iformation.jeu.caracteristiques;

/**
 * Classe qui représente une caractéristique de force.
 * @author Joël Troch
 */
public class CaracteristiqueForce extends Caracteristique {
	/**
	 * Crée une nouvelle caractéristique de force.
	 * @param niveau Le niveau actuel de cette caractéristique de force.
	 */
	public CaracteristiqueForce(int niveau) {
		super("Force", niveau);
	}

	@Override
	public String getNomCourt() {
		return "FOR";
	}
}
