package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueForce;
import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueIntelligence;

/**
 * Classe qui représente la statistique initiative.
 * @author Joël Troch
 */
public class StatistiqueInitiative extends Statistique {
	/** La caractéristique force utilisée pour booster cette statistique initiative. */
	private final CaracteristiqueForce caracteristiqueForce;
	/** La caractéristique intelligence utilisée pour booster cette statistique initiative. */
	private final CaracteristiqueIntelligence caracteristiqueIntelligence;

	/**
	 * Crée une statistique initiative en utilisant une caractéristique force et intelligence spécifiques en guise de booster.
	 * @param caracteristiqueForce La caractéristique force à utiliser en guise de booster pour cette nouvelle statistique d'initiative.
	 * @param caracteristiqueIntelligence La caractéristique d'intelligence à utiliser en guise de booster pour cette statistique d'initiative.
	 */
	public StatistiqueInitiative(CaracteristiqueForce caracteristiqueForce, CaracteristiqueIntelligence caracteristiqueIntelligence) {
		this.caracteristiqueForce = caracteristiqueForce;
		this.caracteristiqueIntelligence = caracteristiqueIntelligence;
	}

	@Override
	public int getValeur() {
		return (this.caracteristiqueForce.getNiveau() +
				this.caracteristiqueIntelligence.getNiveau()) / 2;
	}

	@Override
	public String toString() {
		return "Initiative";
	}
}
