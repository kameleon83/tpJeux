package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueVitalite;

/**
 * Classe qui représente la statistique de vitalité.
 * @author Joël Troch
 */
public class StatistiqueVie extends Statistique {
	/** La caractéristique de vitalité liée à cette statistique de vie. */
	private final CaracteristiqueVitalite caracteristiqueVitalite;

	/**
	 * Crée une statistique de vitalité en utilisant une caractéristique de vitalité spécifique pour spécifier la santé maximum.
	 * @param caracteristiqueVitalite La caractéristique de vitalité à utiliser dans cette statistique.
	 */
	public StatistiqueVie(CaracteristiqueVitalite caracteristiqueVitalite) {
		this.caracteristiqueVitalite = caracteristiqueVitalite;
	}

	@Override
	public int getValeur() {
		return 30 + 3 * this.caracteristiqueVitalite.getNiveau();
	}

	@Override
	public String toString() {
		return "Vitalité";
	}
}
