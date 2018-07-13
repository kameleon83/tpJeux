package fr.joeltroch.m2iformation.jeu.statistiques;

import fr.joeltroch.m2iformation.jeu.caracteristiques.CaracteristiqueMemoire;

/**
 * Classe qui représente la statistique de mana.
 * @author Joël Troch
 */
public class StatistiqueMana extends Statistique {
	/** La caractéristique mémoire liée à cette statistique mana. */
	private final CaracteristiqueMemoire caracteristiqueMemoire;

	/**
	 * Crée une statistique de mana en utilisant une caractéristique de mémoire spécifique pour spécifier la quantité maximum de mana.
	 * @param caracteristiqueMemoire La caractéristique de mémoire à utiliser pour cette statistique de mémoire.
	 */
	public StatistiqueMana(CaracteristiqueMemoire caracteristiqueMemoire) {
		this.caracteristiqueMemoire = caracteristiqueMemoire;
	}

	@Override
	public int getValeur() {
		return 3 * this.caracteristiqueMemoire.getNiveau();
	}

	@Override
	public String toString() {
		return "Mana";
	}
}
