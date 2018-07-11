package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueIntelligence;

/**
 * Classe qui représente des dégâts magique.
 * @author Joël Troch
 */
public class StatistiqueDegatsMagique extends StatistiqueDegats {
	/** La caractéristique intelligence pour booster les dégâts de base. */
	private final CaracteristiqueIntelligence caracteristiqueIntelligence;

	/**
	 * Crée des dégâts magique avec une quantité de dégâts de base et une caractéristique intelligence en guise de booster spécifiques.
	 * @param degats La quantité de dégâts de base.
	 * @param caracteristiqueIntelligence La caractéristique intelligence en guise de booster.
	 */
	public StatistiqueDegatsMagique(int degats, CaracteristiqueIntelligence caracteristiqueIntelligence) {
		super(degats);
		this.caracteristiqueIntelligence = caracteristiqueIntelligence;
	}

	@Override
	public int getValeur() {
		return this.degats * (this.caracteristiqueIntelligence.getNiveau() / 10);
	}

	@Override
	public String toString() {
		return "Dégâts magique";
	}
}
