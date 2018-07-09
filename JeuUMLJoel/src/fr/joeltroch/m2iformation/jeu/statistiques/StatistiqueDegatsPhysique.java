package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueForce;

/**
 * Classe qui représente des dégâts physique.
 * @author Joël Troch
 */
public class StatistiqueDegatsPhysique extends StatistiqueDegats {
	/** La caractéristique force pour booster les dégâts de base. */
	private final CaracteristiqueForce caracteristiqueForce;

	/**
	 * Crée des dégâts physique avec une quantité de dégâts de base et une caractéristique force en guise de booster spécifiques.
	 * @param degats La quantité de dégâts de base.
	 * @param caracteristiqueForce La caractéristique force en guise de booster.
	 */
	public StatistiqueDegatsPhysique(int degats, CaracteristiqueForce caracteristiqueForce) {
		super(degats);
		this.caracteristiqueForce = caracteristiqueForce;
	}

	@Override
	public int getValeur() {
		return this.degats * (this.caracteristiqueForce.getNiveau() / 10);
	}

	@Override
	public String toString() {
		return "Dégât physique";
	}
}
