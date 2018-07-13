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
		// Sur le GDD de Julien V, c'était 10, j'ai mis 2 histoire que le soin de soins soit utile.
		return this.degats * (this.caracteristiqueIntelligence.getNiveau() / 2);
	}

	@Override
	public String toString() {
		return "Dégâts magique";
	}
}
